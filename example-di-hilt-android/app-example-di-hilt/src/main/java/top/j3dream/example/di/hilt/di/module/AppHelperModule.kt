package top.j3dream.example.di.hilt.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import top.j3dream.example.di.hilt.di.testmodel.AppHelper
import javax.inject.Singleton

/**
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