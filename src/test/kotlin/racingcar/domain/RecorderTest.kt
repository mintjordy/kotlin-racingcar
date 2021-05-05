package racingcar.domain

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import racingcar.domain.fixture.AlwaysOneMovingStrategy

internal class RecorderTest {

    @Test
    fun `record - 라운드별 자동차들의 정보를 추가한다`() {
        // given
        val recorder = Recorder()
        val oneRoundResult = Cars(listOf(Car("1"), Car("2"), Car("3")))
        val twoRoundResult = Cars(listOf(Car("1", 1), Car("2"), Car("3", 2)))

        // when
        recorder.record(oneRoundResult)
        recorder.record(twoRoundResult)

        // then
        val result = recorder.result
        result.size `should be equal to` 2
        result[0].cars.size `should be equal to` 3
        result[0].cars[0] `should be equal to` Car("1")
        result[0].cars[1] `should be equal to` Car("2")
        result[0].cars[2] `should be equal to` Car("3")

        result[1].cars.size `should be equal to` 3
        result[1].cars[0] `should be equal to` Car("1", 1)
        result[1].cars[1] `should be equal to` Car("2")
        result[1].cars[2] `should be equal to` Car("3", 2)
    }

    @Test
    fun `record - 레코더에 이미 추가된 자동차를 꺼내서 추가로 이동 시키더라도 레코드에 영향이 없다`() {
        // given
        val recorder = Recorder()
        val oneRoundResult = Cars(listOf(Car("1"), Car("2"), Car("3")))

        // when
        recorder.record(oneRoundResult)
        val result = recorder.result
        result[0].run(AlwaysOneMovingStrategy())

        // then
        result[0].cars.size `should be equal to` 3
        result[0].cars[0] `should be equal to` Car("1")
        result[0].cars[1] `should be equal to` Car("2")
        result[0].cars[2] `should be equal to` Car("3")
    }

    @Test
    fun `findWinner - 최종라운드에 승리한 자동차 목록을 반환`() {
        // given
        val recorder = Recorder()
        val oneRoundResult = Cars(listOf(Car("1"), Car("2"), Car("3")))
        val twoRoundResult = Cars(listOf(Car("1", 1), Car("2"), Car("3", 2)))
        val thirdRoundResult = Cars(listOf(Car("1", 2), Car("2", 3), Car("3", 3)))
        recorder.record(oneRoundResult)
        recorder.record(twoRoundResult)
        recorder.record(thirdRoundResult)

        // when
        val winners = recorder.findWinner()

        // then
        winners.size `should be equal to` 2
        winners[0] `should be equal to` Car("2", 3)
        winners[1] `should be equal to` Car("3", 3)
    }
}