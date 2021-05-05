package racingcar

import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.Round
import racingcar.domain.strategy.move.UnitWithMinimumPowerMovingStrategy
import racingcar.domain.strategy.power.RandomPowerGenerator
import racingcar.ui.inputCarNames
import racingcar.ui.inputRound
import racingcar.ui.printResult

fun main() {
    val carNames = inputCarNames()
    val round = inputRound()
    val movingStrategy = UnitWithMinimumPowerMovingStrategy(RandomPowerGenerator())
    val playResult = RacingGame().play(Cars.from(carNames), Round(round), movingStrategy)
    printResult(playResult)
}
