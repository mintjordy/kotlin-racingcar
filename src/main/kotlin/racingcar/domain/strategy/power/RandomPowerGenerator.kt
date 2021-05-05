package racingcar.domain.strategy.power

class RandomPowerGenerator : PowerGenerator {
    override fun generatePower(): Int = (MIN_VALUE_BOUND..MAX_VALUE_BOUND).random()

    companion object {
        private const val MIN_VALUE_BOUND = 1
        private const val MAX_VALUE_BOUND = 10
    }
}
