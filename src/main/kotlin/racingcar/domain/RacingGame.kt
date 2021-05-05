package racingcar.domain

import racingcar.domain.strategy.move.MovingStrategy

class RacingGame {

    fun play(cars: Cars, round: Round, movingStrategy: MovingStrategy): Recorder {
        var players = cars
        val recorder = Recorder()
        repeat(round.value) {
            players = players.run(movingStrategy)
            recorder.record(players)
        }
        return recorder
    }
}
