package top.j3dream.example.di.hilt.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import top.j3dream.example.di.hilt.di.testmodel.BaseballCap
import top.j3dream.example.di.hilt.di.testmodel.CowboyCap
import top.j3dream.example.di.hilt.di.testmodel.ICap
import javax.inject.Named
import javax.inject.Qualifier

///// region 如何实现主要是为了标记多示例的情况下如何注入
///1. 单一注解通过自定义属性
enum class CapEnums {
    COWBOY, BASEBALL
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Cap(val type: CapEnums)

///2. 通过多个注解表示不同的类型
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CowboyCapType

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseballCapType

///3. 使用 @Named("key") 提供不同的类型
//@Named("Cowboy")
//@Provides
//fun provideNamedAnnotationCowboyCap() = CowboyCap()

/**
 * @author Jia Junjian
 * @since 2021/9/1 17:34
 */
@Module
@InstallIn(ActivityComponent::class)
class CapModule {

    @Cap(CapEnums.COWBOY)
    @Provides
    fun provideSingleAnnotationCowboyCap(): ICap = CowboyCap()

    @Cap(CapEnums.BASEBALL)
    @Provides
    fun provideSingleAnnotationBaseballCap(): ICap = BaseballCap()

    @CowboyCapType
    @Provides
    fun provideTypeAnnotationCowboyCap(): ICap = CowboyCap()

    @BaseballCapType
    @Provides
    fun provideTypeAnnotationBaseballCap(): ICap = BaseballCap()

    @Named("Cowboy")
    @Provides
    fun provideNamedAnnotationCowboyCap(): ICap = CowboyCap()

    @Named("Baseball")
    @Provides
    fun provideNamedAnnotationBaseballCap(): ICap = BaseballCap()
}