package racingcar.domain

import org.amshove.kluent.AnyException
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should not throw`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.`with message`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Test

internal class DistanceTest {

    @Test
    fun `create - Distance 값이 최솟값 보다 작은 경우, 예외 발생`() {
        // given
        val value = -1

        // expected
        invoking { Distance(value) }
            .`should throw`(IllegalArgumentException::class)
            .`with message`("위치 값은 0보다 작을 수 없습니다.")
    }

    @Test
    fun `create - 최소 위치 값 조건을 만족하는 경우, 예외 발생없이 객체 생성`() {
        // given
        val value = 0

        // expected
        invoking { Distance(value) } `should not throw` AnyException
    }

    @Test
    fun `plus - 두 Distance 인스턴드의 덧셈시, 각 value의 합을 포장한 Distance 객체 반환`() {
        // given
        val firstOperand = Distance(5)
        val secondOperand = Distance(4)

        // when
        val actual = firstOperand + secondOperand

        // then
        actual `should be equal to` Distance(9)
    }
}