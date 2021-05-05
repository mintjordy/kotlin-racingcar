package racingcar.domain

class Cars(val cars: List<Car>) {
    constructor(vararg cars: Car) : this(cars.toList())

    fun findWinner(): List<Car> {
        val maximumDistance = cars.maxBy { it.distance }?.distance!!
        return cars.filter { it.isSameDistance(maximumDistance) }
    }
}