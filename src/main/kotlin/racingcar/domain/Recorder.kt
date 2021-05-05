package racingcar.domain

class Recorder(private val records: MutableList<Cars> = mutableListOf()) {

    val result: List<Cars>
        get() = records.toList()

    fun record(cars: Cars) {
        records.add(cars)
    }

    fun findWinner(): List<Car> = records.last().findAllByMaximumDistance()
}