package top.j3dream.example.di.hilt.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import top.j3dream.example.di.hilt.di.testmodel.AppHelper
import javax.inject.Singleton

/**
 *
 * 如果要使用 @Singleton 提供单例. 则只能使用 'SingletonComponent::class' 作用域提供全局单例.
 *
 * 当我们去掉 @Singleton 时, 因为我们使用的作用域为 SingletonComponent::class。
 * 重新运行程序会发现 'AppHelper' 仍然是作为单例提供的. 但是如果我们使用 Provider<AppHelper> 类型获取 AppHelper 实例
 * 会发现获取了新的对象. 如果为provideAppHelper添加了 @Singleton 注释则永远都会提供同一个实例
 *
 * 同样我们也可以通过 ActivityComponent + ActivityScoped 实现局部的单例。
 *
 * @author Jia Junjian
 * @since 2021/9/1 17:58
 */
@Module
@InstallIn(SingletonComponent::class)
class AppHelperModule {

    @Provides
    @Singleton
    fun provideAppHelper(): AppHelper = AppHelper()
}