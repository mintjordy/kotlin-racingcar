package racingcar.domain

data class Car(val name: Name, val distance: Distance) {

    constructor(name: String, distance: Int) : this(Name(name), Distance(distance))

    fun run(movingStrategy: MovingStrategy): Car {
        if (movingStrategy.isMovable()) {
            return Car(name, movingStrategy.move(distance))
        }
        return this
    }
}