package top.j3dream.example.di.hilt.di.testmodel

/**
 * @author Jia Junjian
 * @since 2021/9/1 17:23
 */

interface ICap {

    /**
     * 帽子类型名称
     */
    fun capTypeName(): String
}

// 对 ICap 的实现 CowboyHat
class CowboyCap : ICap {

    override fun capTypeName(): String = "牛仔帽子"
}

// 对 ICap 的实现 BaseballCap
class BaseballCap : ICap {

    override fun capTypeName(): String = "棒球帽"
}
