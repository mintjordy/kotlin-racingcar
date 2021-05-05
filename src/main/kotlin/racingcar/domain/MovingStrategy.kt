package racingcar.domain

interface MovingStrategy {
    fun isMovable(): Boolean
    fun move(distance: Distance): Distance
}