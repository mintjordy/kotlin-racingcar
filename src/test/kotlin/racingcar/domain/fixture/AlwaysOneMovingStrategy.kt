package racingcar.domain.fixture

import racingcar.domain.Distance
import racingcar.domain.strategy.move.MovingStrategy

class AlwaysOneMovingStrategy : MovingStrategy {

    override fun isMovable(): Boolean = true

    override fun move(distance: Distance): Distance = distance + Distance(1)
}
