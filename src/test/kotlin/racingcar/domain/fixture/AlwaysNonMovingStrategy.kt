package racingcar.domain.fixture

import racingcar.domain.Distance
import racingcar.domain.MovingStrategy
import java.lang.UnsupportedOperationException

class AlwaysNonMovingStrategy: MovingStrategy {

    override fun isMovable(): Boolean = false

    override fun move(distance: Distance): Distance = throw UnsupportedOperationException()
}