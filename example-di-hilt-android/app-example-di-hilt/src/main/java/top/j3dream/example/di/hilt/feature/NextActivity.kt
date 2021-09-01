package top.j3dream.example.di.hilt.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import top.j3dream.example.di.hilt.databinding.ActivityNextBinding
import top.j3dream.example.di.hilt.di.testmodel.AppConfig
import top.j3dream.example.di.hilt.di.testmodel.AppHelper
import javax.inject.Inject

/**
 * 用于测试 MainActivity Hilt中的单例
 * @author Jia Junjian
 * @since 2021/9/1 16:19
 */
@AndroidEntryPoint
class NextActivity : AppCompatActivity() {

    @Inject
    lateinit var mAppConfig: AppConfig

    @Inject
    lateinit var mAppHelper: AppHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView
        val viewBinding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.tvNextTestAction.setOnClickListener {

            mAppConfig.printAppConfigCode()

            mAppHelper.printAppHelperCode()
        }
    }
}