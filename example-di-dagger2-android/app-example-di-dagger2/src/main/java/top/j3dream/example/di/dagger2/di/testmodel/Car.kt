package top.j3dream.example.di.dagger2.di.testmodel

import javax.inject.Inject

/**
 * @author Jia Junjian
 * @since 2021/8/31 14:56
 */
abstract class Car(
    /**
     * 发动机
     */
    private val _engine: Engine,
    /**
     * 车牌编号
     */
    private val _plateNumber: String,
    /**
     * 轮胎/车胎
     */
    private val _tire: Tire,
    /**
     * 车架/框架
     */
    private val _frame: Frame
) {

    val engine: Engine get() = _engine
    val plateNumber: String get() = _plateNumber
    val tire: Tire get() = _tire
    val frame: Frame get() = _frame

    /**
     * 车辆品牌
     */
    abstract fun getBrand(): String

    /**
     * 车辆型号
     */
    abstract fun getModel(): String

    /**
     * 轮胎
     * : brand: 品牌
     */
    class Tire @Inject constructor() {
        val brand: String = "米其林Michelin"
    }

    /**
     * 定义车架.
     * : material: 材质
     */
    class Frame @Inject constructor() {
        val material: String = "铝合金"
    }
}