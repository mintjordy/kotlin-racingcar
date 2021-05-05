package racingcar.domain.fixture

import racingcar.domain.Distance
import racingcar.domain.MovingStrategy

class AlwaysOneMovingStrategy: MovingStrategy {

    override fun isMovable(): Boolean = true

    override fun move(distance: Distance): Distance {
        return distance + Distance(1)
    }
}