package racingcar.domain.strategy.power

import kotlin.random.Random

class RandomPowerGenerator : PowerGenerator {
    override fun generatePower(): Int = Random.nextInt(RANDOM_VALUE_BOUND)

    companion object {
        private const val RANDOM_VALUE_BOUND = 10
    }
}
