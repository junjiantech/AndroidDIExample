package top.j3dream.example.di.hilt.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import top.j3dream.example.di.hilt.di.testmodel.AppHelper

/**
 *
 * 如果要使用 @Singleton 提供单例. 则只能使用 'SingletonComponent::class' 作用域提供全局单例.
 *
 * 当我们去掉 @Singleton 时, 因为我们使用的作用域为 SingletonComponent::class。
 * 重新运行程序会发现 'AppHelper' 仍然是作为单例提供的.
 *
 * @author Jia Junjian
 * @since 2021/9/1 17:58
 */
@Module
@InstallIn(SingletonComponent::class)
class AppHelperModule {

    @Provides
    //@Singleton
    fun provideAppHelper(): AppHelper = AppHelper()
}