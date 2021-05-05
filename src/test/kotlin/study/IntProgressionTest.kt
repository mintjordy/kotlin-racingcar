package study

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.`with message`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Test

class IntProgressionTest {

    @Test
    fun `IntRange - IntRange 객체를 리터럴로 표현할 수 있다`() {
        // given
        val start = 1
        val end = 5

        // when
        val actual: IntRange = start..end

        // then
        actual.first `should be equal to` 1
        actual.last `should be equal to` 5
        actual.step `should be equal to` 1
        actual.contains(0) `should be equal to` false
        actual.contains(1) `should be equal to` true
        actual.contains(2) `should be equal to` true
        actual.contains(3) `should be equal to` true
        actual.contains(4) `should be equal to` true
        actual.contains(5) `should be equal to` true
        actual.contains(6) `should be equal to` false
    }

    @Test
    fun `IntProgression - IntProgression 객체를 리터럴로 표현할 수 있다`() {
        // given
        val start = 1
        val end = 5
        val step = 2

        // when
        val actual: IntProgression = start..end step step

        // then
        actual.first `should be equal to` 1
        actual.last `should be equal to` 5
        actual.step `should be equal to` 2
        actual.contains(0) `should be equal to` false
        actual.contains(1) `should be equal to` true
        actual.contains(2) `should be equal to` false
        actual.contains(3) `should be equal to` true
        actual.contains(4) `should be equal to` false
        actual.contains(5) `should be equal to` true
        actual.contains(6) `should be equal to` false
    }

    @Test
    fun `IntProgression - IntProgression 객체생성시 step은 양수가 되어야 한다`() {
        // given
        val start = 1
        val end = 5
        val step = -2

        // expect
        invoking { start..end step step }
            .`should throw`(IllegalArgumentException::class)
            .`with message`("Step must be positive, was: -2.")
    }

    @Test
    fun `IntProgression - 상향 IntProgression 객체의 start가 end보다 큰경우 비어있는 IntProgression 객체 반환`() {
        // given
        val start = 5
        val end = 1
        val step = 2

        // when
        val actual = start..end step step

        // then
        actual.first `should be equal to` 5
        actual.last `should be equal to` 1
        actual.step `should be equal to` 2
        actual.isEmpty() `should be equal to` true
    }

    @Test
    fun `IntProgression - 감소하는 Range 객체 는 Int의 downTo 중위 확장 함수로 생성할 수 있다`() {
        // given
        val start = 5
        val end = 1

        // when
        val actual = start downTo end

        // then
        actual.first `should be equal to` 5
        actual.last `should be equal to` 1
        actual.step `should be equal to` -1
        actual.isEmpty() `should be equal to` false
    }

    @Test
    fun `IntProgression2 - 감소하는 Range 객체 는 start가 end보다 크면 비어있는 객체 반환한다`() {
        // given
        val start = 1
        val end = 5

        // when
        val actual = start downTo end

        // then
        actual.first `should be equal to` 1
        actual.last `should be equal to` 5
        actual.step `should be equal to` -1
        actual.isEmpty() `should be equal to` true
    }
}