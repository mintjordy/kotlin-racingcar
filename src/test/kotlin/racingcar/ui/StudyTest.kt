package racingcar.ui

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.NumberFormatException

@DisplayName("String extension 함수 학습테스트")
internal class StudyTest {

    @Test
    fun `String toInt(숫자인 값) - 숫자로 변경`() {
        // given
        val data = "1"

        // when
        val actual = data.toInt()

        // then
        actual `should be equal to` 1
    }

    @Test
    fun `String toInt(숫자가 아닌값) - 예외 발생`() {
        // given
        val data = "wgjpwe"

        // expected
        invoking { data.toInt() }
            .`should throw`(NumberFormatException::class)
    }

    @Test
    fun `String toIntOrNull(숫자가 아닌값) - null반환`() {
        // given
        val data = "jordy"

        // expected
        val actual = data.toIntOrNull()

        // then
        actual `should be equal to` null
    }

    @Test
    fun `String get api를 통해 index 번째의 char 반환 및 인덱스로 접근 가능`() {
        // given
        val data = "jordy"

        // expected
        val actual = data[0]

        // then
        actual `should be equal to` 'j'
    }
}