package racingcar.domain.fixture

import racingcar.domain.Distance
import racingcar.domain.strategy.move.MovingStrategy
import java.lang.UnsupportedOperationException

class AlwaysNonMovingStrategy: MovingStrategy {

    override fun isMovable(): Boolean = false

    override fun move(distance: Distance): Distance = throw UnsupportedOperationException()
}