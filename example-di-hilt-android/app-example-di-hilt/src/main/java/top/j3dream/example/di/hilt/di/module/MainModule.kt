package top.j3dream.example.di.hilt.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import top.j3dream.example.di.hilt.di.testmodel.SystemPrinter

/**
 * @author Jia Junjian
 * @since 2021/9/1 17:20
 */
@Module
@InstallIn(ActivityComponent::class)
class MainModule {

    @Provides
    fun provideSystemPrinter(): SystemPrinter = SystemPrinter("Android System")
}