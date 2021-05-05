package racingcar.domain

data class Round(val value: Int) {
    init {
        require(value in MIN_VALUE..MAX_VALUE) { "경주 가능한 범위가 아닙니다." }
    }

    companion object {
        private const val MIN_VALUE = 1
        private const val MAX_VALUE = 8
    }
}
