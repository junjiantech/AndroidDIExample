package top.j3dream.example.di.dagger2.di.component

import dagger.Component
import top.j3dream.example.di.dagger2.di.module.CarShowModule
import top.j3dream.example.di.dagger2.di.testmodel.ICarShow
import javax.inject.Singleton

/**
 * @author Jia Junjian
 * @since 2021/9/1 10:33
 */
@Singleton
@Component(modules = [CarShowModule::class])
interface CarShowComponent {

    /**
     * 提供 ICarShow 的实例
     */
    fun getCarShow(): ICarShow
}