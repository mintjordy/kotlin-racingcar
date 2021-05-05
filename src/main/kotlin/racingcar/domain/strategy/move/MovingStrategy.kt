package racingcar.domain.strategy.move

import racingcar.domain.Distance

interface MovingStrategy {
    fun isMovable(): Boolean
    fun move(distance: Distance): Distance
}