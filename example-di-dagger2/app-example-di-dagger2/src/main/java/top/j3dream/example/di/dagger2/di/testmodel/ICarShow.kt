package top.j3dream.example.di.dagger2.di.testmodel

import android.util.Log
import top.j3dream.example.di.dagger2.feature.MainActivity
import javax.inject.Inject

/**
 *
 * 车秀
 *
 * @author Jia Junjian
 * @since 2021/9/1 10:27
 */
interface ICarShow {

    /**
     * 展示车辆
     * @param driver 驾驶员
     * @param car 车辆
     */
    fun show(driver: Driver, car: Car)
}

class CarPrintShow @Inject constructor() : ICarShow {
    override fun show(driver: Driver, car: Car) {
        // 打印程序信息.
        Log.e(
            MainActivity.TAG, String.format(
                "Driver (%s) play CAR(%s): [%s(%s)] use %s engine; tire: %s; frame: %s",
                driver.getDriverName(),
                car.plateNumber,
                car.getBrand(),
                car.getModel(),
                car.engine.engineName(),
                car.tire.brand,
                car.frame.material
            )
        )
    }
}