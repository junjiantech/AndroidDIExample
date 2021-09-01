package top.j3dream.example.di.hilt.di.testmodel

import javax.inject.Inject

/**
 * 抽象上衣为一个接口 IJacket. 具体类型的上衣应该实现该接口
 * @author Jia Junjian
 * @since 2021/9/1 17:03
 */
interface IJacket {

    /**
     * 获取上衣类型名称
     * @return 上衣类型名称
     */
    fun jacketTypeName(): String
}

// 花色夹克
class FloralJacket @Inject constructor() : IJacket {

    override fun jacketTypeName(): String = "花色夹克"
}