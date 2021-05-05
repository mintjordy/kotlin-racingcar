package racingcar.domain

import racingcar.domain.strategy.move.MovingStrategy

class Cars(val cars: List<Car>) {
    constructor(vararg cars: Car) : this(cars.toList())

    fun run(movingStrategy: MovingStrategy): Cars = Cars(cars.map { it.run(movingStrategy) })

    fun findAllByMaximumDistance(): List<Car> {
        val maximumDistance = cars.maxBy { it.distance }!!.distance
        return cars.filter { it.isSameDistance(maximumDistance) }
    }
}