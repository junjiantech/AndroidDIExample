package top.j3dream.example.di.hilt.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import top.j3dream.example.di.hilt.di.testmodel.SystemPrinter

/**
 * 当未进行任何注解的时候, 则当前提供的 SystemPrinter 为 @InstallIn 作用域范围内的局部单例.
 * 如果需要每次都提供一个新的对象使用. 查看 {@see javax.inject.Provider}
 * @author Jia Junjian
 * @since 2021/9/1 17:20
 */
@Module
@InstallIn(ActivityComponent::class)
class MainModule {

    @Provides
    fun provideSystemPrinter(): SystemPrinter = SystemPrinter("Android System")
}