package top.j3dream.example.di.dagger2.di.testmodel

import javax.inject.Inject

/**
 * @author Jia Junjian
 * @since 2021/8/31 14:52
 */
// 对于汽车发动机的抽象于实现
interface Engine {

    /**
     * 发动机名称
     */
    fun engineName(): String
}

// 涡轮增加发动机
class TurbochargedEngine @Inject constructor() : Engine {

    // 实现 Engine 中的 engineName 返回发动机名称
    override fun engineName(): String = "涡轮增压发动机"
}

// 自然吸气发动机
class NaturallyAspiratedEngine @Inject constructor() : Engine {

    override fun engineName(): String = "自然吸气发动机"
}