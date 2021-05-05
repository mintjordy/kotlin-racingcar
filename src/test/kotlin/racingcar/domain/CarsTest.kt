package racingcar.domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CarsTest {

    @Test
    fun `create - 자동차 이름을 받아 Cars 객체 생성`() {
        // given
        val first = Car("abc")
        val second = Car("def")
        val third = Car("ghi")

        // when
        val actual = Cars(first, second, third)

        // then
        actual.cars.size `should be equal to` 3
    }

    @ParameterizedTest
    @MethodSource("provideForFindWinners")
    fun `findWinners - 가장 큰 변위를 가진 자동차들을 반환`(cars: Cars, expected: List<Car>) {
        // when
        val actual = cars.findWinner()

        // then
        actual `should be equal to` expected
    }

    companion object {

        @JvmStatic
        private fun provideForFindWinners(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Cars(Car("1번마"), Car("2번마", 1), Car("3번마", 3)),
                    listOf(Car("3번마", 3))
                ),
                Arguments.of(
                    Cars(Car("1번마"), Car("2번마", 1), Car("3번마", 3), Car("4번마", 3)),
                    listOf(Car("3번마", 3), Car("4번마", 3))
                )
            )
        }
    }
}