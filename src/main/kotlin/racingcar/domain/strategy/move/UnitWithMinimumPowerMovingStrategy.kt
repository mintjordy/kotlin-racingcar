package racingcar.domain.strategy.move

import racingcar.domain.Distance
import racingcar.domain.strategy.power.PowerGenerator

class UnitWithMinimumPowerMovingStrategy(private val powerGenerator: PowerGenerator) : MovingStrategy {

    override fun isMovable(): Boolean = powerGenerator.generatePower() >= CRITERIA_TO_MOVE

    override fun move(distance: Distance): Distance = distance + Distance(DISTANCE_TO_MOVE)

    companion object {
        private const val CRITERIA_TO_MOVE = 4
        private const val DISTANCE_TO_MOVE = 1
    }
}