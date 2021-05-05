package racingcar.domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.domain.fixture.AlwaysNonMovingStrategy
import racingcar.domain.fixture.AlwaysOneMovingStrategy

internal class CarTest {

    @Test
    fun `run - 자동차가 움직이면 distance가 변한 Car 반환`() {
        // given
        val car = Car("test", 0)

        // when
        val actual = car.run(AlwaysOneMovingStrategy())

        // then
        actual `should be equal to` Car("test", 1)
    }

    @Test
    fun `run - 자동차가 움직이지 않는다면 distance 변화 없는 Car 객체 반환`() {
        // given
        val car = Car("test", 0)

        // when
        val actual = car.run(AlwaysNonMovingStrategy())

        // then
        actual `should be equal to` Car("test", 0)
    }

    @ParameterizedTest
    @CsvSource("1, 1, true", "1, 2, false")
    fun `isSameDistance - Car의 distance가 인자로 받은 distance와 같은지 여부를 확인`(carDistance: Int, argDistance: Int, expected: Boolean) {
        // given
        val car = Car("test", carDistance)
        val distance = Distance(argDistance)

        // when
        val actual = car.isSameDistance(distance)

        // then
        actual `should be equal to` expected
    }
}