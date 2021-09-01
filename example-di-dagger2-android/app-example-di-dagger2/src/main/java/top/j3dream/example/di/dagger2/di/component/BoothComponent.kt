package top.j3dream.example.di.dagger2.di.component

import dagger.Subcomponent
import top.j3dream.example.di.dagger2.di.module.BoothModule
import top.j3dream.example.di.dagger2.feature.MainActivity

/**
 * @author Jia Junjian
 * @since 2021/9/1 08:53
 */
@Subcomponent(modules = [BoothModule::class])
interface BoothComponent {

    /**
     * 此函数会告知 Dagger MainActivity 希望访问该图并请求注入.
     */
    fun inject(mainActivity: MainActivity)
}