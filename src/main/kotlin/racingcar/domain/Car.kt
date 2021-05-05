package racingcar.domain

import racingcar.domain.strategy.move.MovingStrategy

data class Car(val name: Name, val distance: Distance = Distance(DEFAULT_DISTANCE)) {

    constructor(name: String) : this(Name(name))

    constructor(name: String, distance: Int) : this(Name(name), Distance(distance))

    fun run(movingStrategy: MovingStrategy): Car {
        if (movingStrategy.isMovable()) {
            return Car(name, movingStrategy.move(distance))
        }
        return this
    }

    fun isSameDistance(distance: Distance): Boolean = this.distance == distance

    companion object {
        private const val DEFAULT_DISTANCE = 0
    }
}