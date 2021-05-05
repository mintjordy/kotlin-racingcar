package racingcar.domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
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
}