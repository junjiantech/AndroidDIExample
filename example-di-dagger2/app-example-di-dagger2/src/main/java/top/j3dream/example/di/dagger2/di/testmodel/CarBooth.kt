package top.j3dream.example.di.dagger2.di.testmodel

/**
 * - 文件描述:
 * @author Jia Junjian
 * @since 2021/9/1 09:56
 */
class CarBooth constructor(private val car: Car, private val show: ICarShow) {

    /**
     * 车辆展示.
     * @param driver 驾驶员
     */
    fun booth(driver: Driver) {

        // 展示车辆
        show.show(driver, car)
    }
}