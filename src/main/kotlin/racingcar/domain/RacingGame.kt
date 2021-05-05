package racingcar.domain

import racingcar.domain.strategy.move.MovingStrategy

class RacingGame {

    fun play(cars: Cars, round: Round, movingStrategy: MovingStrategy): Recorder {
        val recorder = Recorder()
        repeat(round.value) {
            val eachRoundResult = cars.run(movingStrategy)
            recorder.record(eachRoundResult)
        }
        return recorder
    }
}