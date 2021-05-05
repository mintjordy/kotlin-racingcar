package racingcar.domain

import org.amshove.kluent.AnyException
import org.amshove.kluent.`should not throw`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.`with message`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class RoundTest {

    @Test
    fun `create - 허용 범위 내에 게임 라운드 객체 생성`() {
        // given
        val value = 5

        // expected
        invoking { Round(value) } `should not throw` AnyException
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 9])
    fun `create - 허용 범위 외 게임 라운드 객체 생성시 예외 발생`(value: Int) {
        // expected
        invoking { Round(value) }
            .`should throw`(IllegalArgumentException::class)
            .`with message`("경주 가능한 범위가 아닙니다.")
    }
}
