package top.j3dream.example.di.dagger2.di.testmodel

/**
 * - 文件描述: 交警. 只有一个可以给车辆颁发车牌
 * @author Jia Junjian
 * @since 2021/8/31 17:55
 */
class TrafficPolice constructor(val tag: Char) {

    /**
     * 生成车牌编号
     * @return 车牌编号
     */
    fun generatePlateNumber(): String {
        return "${tag.uppercaseChar()}-${(10000..99999).random()}"
    }
}