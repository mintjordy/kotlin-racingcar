package racingcar.domain

import org.amshove.kluent.AnyException
import org.amshove.kluent.`should not throw`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.`with message`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class NameTest {

    @Test
    fun `Name - 빈값이 아니고, 5자 이하의 이름 객체 생성`() {
        // given
        val value = "jordy"

        // expect
        invoking { Name(value) } `should not throw` AnyException
    }

    @Test
    fun `Name - 빈 값에 대한 이름 객체 생성시 예외 발생`() {
        // given
        val value = ""

        // expect
        invoking { Name(value) }
            .`should throw`(IllegalArgumentException::class)
            .`with message`("빈 값이 이름이 될 수 없습니다.")
    }

    @Test
    fun `Name - 최대 길이보다 큰 길이의 이름 객체 생성시 예외 발생`() {
        // given
        val value = "overTheJordy"

        // expected
        invoking { Name(value) }
            .`should throw`(IllegalArgumentException::class)
            .`with message`("이름의 길이는 5자보다 길 수 없습니다.")
    }
}