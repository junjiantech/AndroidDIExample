package top.j3dream.example.di.hilt.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import top.j3dream.example.di.hilt.di.testmodel.FloralJacket
import top.j3dream.example.di.hilt.di.testmodel.IJacket

/**
 * @author Jia Junjian
 * @since 2021/9/1 17:07
 */
@Module
@InstallIn(ActivityComponent::class)
interface JacketModule {

    /**
     * 绑定 IJacket 为 [FloralJacket]. 意为: 如果获取 IJacket 的实现则会将 FloralJacket 返回
     */
    @Binds
    fun bindUserJacket(jacket: FloralJacket): IJacket
}