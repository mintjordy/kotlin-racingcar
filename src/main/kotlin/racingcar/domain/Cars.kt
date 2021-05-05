package racingcar.domain

import racingcar.domain.strategy.move.MovingStrategy

class Cars(val cars: List<Car>) {

    init {
        require(cars.size >= MINIMUM_COUNT_OF_CAR) { "최소 ${MINIMUM_COUNT_OF_CAR}대의 차가 필요합니다." }
    }

    constructor(vararg cars: Car) : this(cars.toList())

    fun run(movingStrategy: MovingStrategy): Cars = Cars(cars.map { it.run(movingStrategy) })

    fun findAllByMaximumDistance(): List<Car> {
        val maximumDistance = cars.maxBy { it.distance }!!.distance
        return cars.filter { it.isSameDistance(maximumDistance) }
    }

    companion object {
        private const val MINIMUM_COUNT_OF_CAR = 2

        fun from(names: List<String>, distance: Int = 0): Cars = Cars(names.map { Car(it, distance) })
    }
}