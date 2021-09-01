package top.j3dream.example.di.hilt.di.testmodel

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 与 Dagger2 不同.Hilt 可以通过 @Singleton + @Inject 直接将该对象设置为全局单例.
 * 而 Dagger2 中如果仅标注两个注解后直接注入会出现 '(unscoped) cannot depend on scoped components' 异常.
 * @author Jia Junjian
 * @since 2021/9/1 15:43
 */
@Singleton
class AppConfig @Inject constructor() {

    companion object {

        private const val TAG = "AppConfig"
    }

    /**
     * 生成一个随机的 code.
     */
    private val mCode: Int by lazy { (0..100).random() }

    fun printAppConfigCode() {
        Log.e(TAG, "AppConfig Code: $mCode")
    }
}