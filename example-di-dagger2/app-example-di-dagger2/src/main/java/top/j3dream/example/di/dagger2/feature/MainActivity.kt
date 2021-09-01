package top.j3dream.example.di.dagger2.feature

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import top.j3dream.example.di.dagger2.databinding.ActivityMainBinding
import top.j3dream.example.di.dagger2.di.component.DaggerMainComponent
import top.j3dream.example.di.dagger2.di.component.DaggerTrafficPoliceComponent
import top.j3dream.example.di.dagger2.di.testmodel.Car
import top.j3dream.example.di.dagger2.di.testmodel.Driver
import javax.inject.Inject

/**
 * 应用程序入口活动
 * @author Jia Junjian
 * @since 2021/8/31 15:06
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mViewBinding: ActivityMainBinding

    @Inject
    lateinit var mCar: Car

    @Inject
    lateinit var mDriver: Driver

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        // tip: 注入时机
        //   使用 Activity 时，应在Activity onCreate()方法中的 super.onCreate() 之前注入 Dagger，以避免出现 Fragment 恢复问题。在 super.onCreate() 中的恢复阶段，Activity 会附加可能需要访问 Activity 绑定的 Fragment。
        //   使用 Fragment 时，应在 Fragment 的 onAttach() 方法中注入 Dagger。在这种情况下，此操作可以在调用 super.onAttach() 之前或之后完成。

        ///region 有两种方式可以实现注入
        // 1. 使用生成的 DaggerMainComponent 的构造者实现注入
        // DaggerMainComponent.builder().build().inject(this)
        // 2. 使用生成的 DaggerMainComponent 的 create() 创建 并注入
        // DaggerMainComponent.create().inject(this)

        // 创建依赖的 Component
        val trafficPoliceComponent = DaggerTrafficPoliceComponent.create()
        // 通过建造者模式创建MainComponent
        DaggerMainComponent.builder()
            .trafficPoliceComponent(trafficPoliceComponent)
            .build().inject(this)

        ///region

        super.onCreate(savedInstanceState)
        // 绑定 ViewBinding.
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
        // 打印程序信息.
        Log.e(
            TAG, String.format(
                "Driver (%s) play CAR(%s): [%s(%s)] use %s engine",
                mDriver.getDriverName(),
                mCar.getPlateNumber(),
                mCar.getBrand(),
                mCar.getModel(),
                mCar.getEngineName()
            )
        )
    }
}