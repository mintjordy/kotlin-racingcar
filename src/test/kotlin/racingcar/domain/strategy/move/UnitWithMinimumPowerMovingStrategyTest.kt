package racingcar.domain.strategy.move

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import racingcar.domain.Distance
import racingcar.domain.fixture.FixedMovablePowerGenerator
import racingcar.domain.fixture.FixedUnMovablePowerGenerator

internal class UnitWithMinimumPowerMovingStrategyTest {

    @Test
    fun `isMovable - 주입받은 파워발전기로 생성한 파워값이 movable을 충족하면 이동 가능하다 `() {
        // given
        val movingStrategy = UnitWithMinimumPowerMovingStrategy(FixedMovablePowerGenerator())

        // when
        val actual = movingStrategy.isMovable()

        // then
        actual `should be equal to` true
    }

    @Test
    fun `isMovable - 주입받은 파워발전기로 생성한 파워값이 movable을 충족하지 못하면 이동 불가능하다`() {
        // given
        val movingStrategy = UnitWithMinimumPowerMovingStrategy(FixedUnMovablePowerGenerator())

        // when
        val actual = movingStrategy.isMovable()

        // then
        actual `should be equal to` false
    }

    @Test
    fun `move - 한칸 이동한 값을 반환한다`() {
        // given
        val movingStrategy = UnitWithMinimumPowerMovingStrategy(FixedMovablePowerGenerator())

        // when
        val actual = movingStrategy.move(Distance(1))

        // then
        actual `should be equal to` Distance(2)
    }
}