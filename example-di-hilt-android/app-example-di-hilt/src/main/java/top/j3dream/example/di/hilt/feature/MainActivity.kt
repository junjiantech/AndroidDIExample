package top.j3dream.example.di.hilt.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import top.j3dream.example.di.hilt.databinding.ActivityMainBinding

/**
 * 应用主页(入口)活动
 * @author Jia Junjian
 * @since 2021/9/1 15:59
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // view binding
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}