package top.j3dream.example.di.dagger2.di.testmodel

import android.util.Log
import top.j3dream.example.di.dagger2.feature.MainActivity

/**
 * - 文件描述:
 * @author Jia Junjian
 * @since 2021/9/1 09:56
 */
class CarBooth constructor(private val car: Car) {

    /**
     * 车辆展示.
     * @param driver 驾驶员
     */
    fun booth(driver: Driver) {
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