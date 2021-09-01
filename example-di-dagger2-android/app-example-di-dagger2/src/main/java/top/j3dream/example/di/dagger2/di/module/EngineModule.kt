package top.j3dream.example.di.dagger2.di.module

import dagger.Binds
import dagger.Module
import top.j3dream.example.di.dagger2.di.testmodel.Engine
import top.j3dream.example.di.dagger2.di.testmodel.TurbochargedEngine

/**
 * @author Jia Junjian
 * @since 2021/8/31 16:59
 */
@Module
abstract class EngineModule {

    /**
     * 简单模式使用 @Binds 为 Engine 接口提供 TurbochargedEngine 的实现
     */
    @Binds
    abstract fun bindEngine(engine: TurbochargedEngine): Engine
}