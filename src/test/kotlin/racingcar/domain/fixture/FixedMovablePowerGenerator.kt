package racingcar.domain.fixture

import racingcar.domain.strategy.power.PowerGenerator

class FixedMovablePowerGenerator : PowerGenerator {
    override fun generatePower(): Int = Int.MAX_VALUE
}