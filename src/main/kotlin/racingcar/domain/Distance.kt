package racingcar.domain

data class Distance(val value: Int) : Comparable<Distance> {

    init {
        require(value >= MINIMUM_VALUE) { "위치 값은 ${MINIMUM_VALUE}보다 작을 수 없습니다." }
    }

    operator fun plus(distance: Distance): Distance = copy(value = value + distance.value)

    override fun compareTo(other: Distance): Int = value - other.value

    companion object {
        private const val MINIMUM_VALUE = 0
    }
}
