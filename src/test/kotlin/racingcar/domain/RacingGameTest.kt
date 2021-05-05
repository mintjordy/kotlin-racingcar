package racingcar.domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import racingcar.domain.fixture.AlwaysOneMovingStrategy

internal class RacingGameTest {

    @Test
    fun `play - 자동차에 대해 입력받은 round만큼 경주 후 round 크기의 결과를 보유한 레코드 반환`() {
        // given
        val cars = Cars(listOf(Car("abc"), Car("def"), Car("ghi")))
        val round = Round(5)

        // when
        val actual = RacingGame().play(cars, round, AlwaysOneMovingStrategy())

        // then
        actual.result.size `should be equal to` 5
    }
}