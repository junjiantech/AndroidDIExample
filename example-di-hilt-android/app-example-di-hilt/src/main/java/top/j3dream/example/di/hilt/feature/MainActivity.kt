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

    @Inject
    lateinit var mAppHelper: AppHelper

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

            mAppHelper.printAppHelperCode()
        }
    }
}