package racingcar.domain.fixture

import racingcar.domain.strategy.power.PowerGenerator

class FixedUnMovablePowerGenerator : PowerGenerator {
    override fun generatePower(): Int = Int.MIN_VALUE
}