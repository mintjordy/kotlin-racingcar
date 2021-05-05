package racingcar.ui

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Recorder

fun printResult(recorder: Recorder) {
    println("실행결과")
    recorder.result.forEach { printCars(it) }
    println("${recorder.findWinner().joinToString { it.name.value }} 가 최종 우승했습니다.")
}

private fun printCars(cars: Cars) {
    cars.cars.forEach { printCar(it) }
    println()
}

private fun printCar(car: Car) {
    println("${car.name.value}: ${"-".repeat(car.distance.value)}")
}
