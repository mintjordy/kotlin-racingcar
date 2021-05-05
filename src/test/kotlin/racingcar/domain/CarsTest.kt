package racingcar.domain

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.`with message`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.fixture.AlwaysOneMovingStrategy
import java.lang.IllegalArgumentException
import java.util.stream.Stream

internal class CarsTest {

    @Test
    fun `create - 자동차 이름을 받아 Cars 객체 생성`() {
        // given
        val first = Car("abc")
        val second = Car("def")
        val third = Car("ghi")

        // when
        val actual = Cars(listOf(first, second, third))

        // then
        actual.cars.size `should be equal to` 3
    }

    @Test
    fun `create - 경기에 필요한 최소 갯수 보다 작은 자동차입력시 예외 발생`() {
        // given
        val first = Car("abc")

        // when
        invoking { Cars(listOf(first)) }
            .`should throw`(IllegalArgumentException::class)
            .`with message`("최소 2대의 차가 필요합니다.")
    }

    @Test
    fun `run - 모든 Car들이 움직인 뒤, 결과를 Cars로 반환`() {
        // given
        val first = Car("abc")
        val second = Car("def")
        val third = Car("ghi")
        val cars = Cars(listOf(first, second, third))

        // when
        val actual = cars.run(AlwaysOneMovingStrategy())

        // then
        actual.cars[0] `should be equal to` Car("abc", 1)
        actual.cars[1] `should be equal to` Car("def", 1)
        actual.cars[2] `should be equal to` Car("ghi", 1)
    }

    @ParameterizedTest
    @MethodSource("provideForFindAllByMaximumDistance")
    fun `findAllByMaximumDistance - 가장 큰 변위를 가진 자동차들을 반환`(cars: Cars, expected: List<Car>) {
        // when
        val actual = cars.findAllByMaximumDistance()

        // then
        actual `should be equal to` expected
    }

    companion object {

        @JvmStatic
        private fun provideForFindAllByMaximumDistance(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Cars(listOf(Car("1번마"), Car("2번마", 1), Car("3번마", 3))),
                    listOf(Car("3번마", 3))
                ),
                Arguments.of(
                    Cars(listOf(Car("1번마"), Car("2번마", 1), Car("3번마", 3), Car("4번마", 3))),
                    listOf(Car("3번마", 3), Car("4번마", 3))
                )
            )
        }
    }
}