package racingcar.domain

data class Name(val value: String) {

    init {
        require(value.isNotBlank()) { "빈 값이 이름이 될 수 없습니다." }
        require(value.length <= MAXIMUM_LENGTH) { "이름의 길이는 ${MAXIMUM_LENGTH}자보다 길 수 없습니다." }
    }

    companion object {
        private const val MAXIMUM_LENGTH = 5
    }
}