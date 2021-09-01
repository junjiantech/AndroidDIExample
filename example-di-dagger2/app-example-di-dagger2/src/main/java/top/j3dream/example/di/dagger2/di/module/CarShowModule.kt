package top.j3dream.example.di.dagger2.di.module

import dagger.Binds
import dagger.Module
import top.j3dream.example.di.dagger2.di.testmodel.CarPrintShow
import top.j3dream.example.di.dagger2.di.testmodel.ICarShow
import javax.inject.Singleton

/**
 * @author Jia Junjian
 * @since 2021/9/1 10:30
 */
@Module
abstract class CarShowModule {

    @Binds
    @Singleton
    abstract fun bindCarShow(show: CarPrintShow): ICarShow
}