package top.j3dream.example.di.dagger2.di.module

import dagger.Module
import dagger.Provides
import top.j3dream.example.di.dagger2.di.testmodel.TrafficPolice

/**
 * - 文件描述:
 * @author Jia Junjian
 * @since 2021/8/31 18:07
 */
@Module
class TrafficPoliceModule {

    /**
     * 提供交通警察单例.
     * @return 交通警察单例
     */
    @Provides
    fun provideTrafficPolice(): TrafficPolice = TrafficPolice('A')
}