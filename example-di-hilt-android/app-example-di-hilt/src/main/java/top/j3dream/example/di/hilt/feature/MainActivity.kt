package top.j3dream.example.di.hilt.feature

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import top.j3dream.example.di.hilt.databinding.ActivityMainBinding
import top.j3dream.example.di.hilt.di.testmodel.AppConfig
import top.j3dream.example.di.hilt.di.testmodel.AppHelper
import top.j3dream.example.di.hilt.di.testmodel.SystemPrinter
import top.j3dream.example.di.hilt.di.testmodel.User
import javax.inject.Inject
import javax.inject.Provider

/**
 * 应用主页(入口)活动
 * @author Jia Junjian
 * @since 2021/9/1 15:59
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    @Inject
    lateinit var mAppConfig: AppConfig

    @Inject
    lateinit var mUser: User

    @Inject
    lateinit var mSystemPrinter: SystemPrinter

    /**
     * Provider 要求每次都实例化新的对象。 但是因为 AppHelper 注解了 @Singleton 则Provider失效
     */
    @Inject
    lateinit var mAppHelper: Provider<AppHelper>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // view binding
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnMainGotoNext.setOnClickListener {
            // 跳转到下一页
            startActivity(Intent(this, NextActivity::class.java))
        }

        viewBinding.tvMainTestAction.setOnClickListener {
            // 打印 mAppConfig 单例
            mAppConfig.printAppConfigCode()
            // 通过注入的 SystemPrinter 打印 用户信息
            mSystemPrinter.printUserInfo(mUser)
            // 虽然使用了 Provider 但是因为在 Module中为提供的方法注释了Singleton, 所以每次 get() 依然会获取同一个对象.
            mAppHelper.get().printAppHelperCode()
        }
    }
}