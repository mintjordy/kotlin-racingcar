package racingcar.domain

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