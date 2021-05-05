package study

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("String extension 함수 학습테스트")
internal class StringTest {

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

    @Test
    fun `repeat - 인자로 받는 숫자 만큼 append한 문자열을 반환`() {
        // given
        val data = "hollys"

        // when
        val actual = data.repeat(5)

        // then
        actual `should be equal to` "hollyshollyshollyshollyshollys"
    }

    @Test
    fun `removeRange - 입력받은 range 범위에 따른 문자를 제거한 나머지 문자열을 반환`() {
        // given
        val data = "coffee"

        // when
        val actual = data.removeRange(0, 3)

        // then
        actual `should be equal to` "fee"
    }

    @Test
    fun `removeRange - Range 타입의 범위에 따른 문자열 제거후 나머지 문자 반환`() {
        // given
        val data = "coffee"
        val closedRange = IntRange(0, 3)

        // when
        val actual = data.removeRange(closedRange)

        // then
        actual `should be equal to` "ee"
    }

    @Test
    fun `subsequence - subString과 같은 기능, 반환타입은 CharSequence이다`() {
        // given
        val data = "coffee"

        // when
        val actual = data.subSequence(0, 3)

        // then
        actual `should be equal to` "cof"
    }

    @Test
    fun `subString - Java의 subString과 같은 기능`() {
        // given
        val data = "coffee"

        // when
        val actual = data.substring(0, 3)

        // then
        actual `should be equal to` "cof"
    }

    @Test
    fun `subString - 인자가 Range Type, last 인덱스도 포함된다`() {
        // given
        val data = "coffee"
        val range = IntRange(0, 3)

        // when
        val actual = data.substring(range)

        // then
        actual `should be equal to` "coff"
    }

    @Test
    fun `capitalize - 첫 글자가 소문자인 경우 첫글자를 대문자로 변경된 새 문자열 반환`() {
        // given
        val data = "coffee is hot!"

        // when
        val actual = data.capitalize()

        // then
        actual `should be equal to` "Coffee is hot!"
    }

    @ParameterizedTest
    @CsvSource("안녕하세요, 안녕하세요", "1Hello world, 1Hello world", ".name, .name")
    fun `capitalize - 첫 글자가 소문자가 아닌 경우 같은 문자 반환`(data: String, expected: String) {
        // when
        val actual = data.capitalize()

        // then
        actual `should be equal to` expected
    }

    @Test
    fun `capitalize - 첫 글자가 대문자인 경우 첫글자를 소문자로 변경된 새 문자열 반환`() {
        // given
        val data = "Coffee is hot!"

        // when
        val actual = data.decapitalize()

        // then
        actual `should be equal to` "coffee is hot!"
    }

    @ParameterizedTest
    @CsvSource("안녕하세요, 안녕하세요", "1Hello world, 1Hello world", ".name, .name")
    fun `capitalize - 첫 글자가 대문자가 아닌 경우 같은 문자 반환`(data: String, expected: String) {
        // when
        val actual = data.capitalize()

        // then
        actual `should be equal to` expected
    }
}
