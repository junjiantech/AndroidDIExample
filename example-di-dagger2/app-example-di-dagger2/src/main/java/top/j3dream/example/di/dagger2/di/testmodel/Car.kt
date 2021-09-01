package top.j3dream.example.di.dagger2.di.testmodel

/**
 * @author Jia Junjian
 * @since 2021/8/31 14:56
 */
abstract class Car(
    private val engine: Engine, private val plateNumber: String
) {

    /**
     * 车辆品牌
     */
    abstract fun getBrand(): String

    /**
     * 车辆型号
     */
    abstract fun getModel(): String

    /**
     * 获取车牌编号
     * @return 车牌编号
     */
    fun getPlateNumber(): String = plateNumber

    /**
     * 获取发动机名称
     * @return 发动机名称
     */
    fun getEngineName(): String = engine.engineName()

    /**
     * 轮胎
     * : brand: 品牌
     */
    data class Tire(val brand: String)

    /**
     * 定义车架.
     * : material: 材质
     */
    data class Frame(val material: String)
}