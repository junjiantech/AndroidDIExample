package top.j3dream.example.di.dagger2.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import top.j3dream.example.di.dagger2.databinding.ActivityMainBinding
import top.j3dream.example.di.dagger2.di.component.DaggerCarShowComponent
import top.j3dream.example.di.dagger2.di.component.DaggerMainComponent
import top.j3dream.example.di.dagger2.di.component.DaggerTrafficPoliceComponent
import top.j3dream.example.di.dagger2.di.module.BoothModule
import top.j3dream.example.di.dagger2.di.testmodel.CarBooth
import top.j3dream.example.di.dagger2.di.testmodel.Driver
import javax.inject.Inject
import javax.inject.Provider

/**
 * 应用程序入口活动
 * @author Jia Junjian
 * @since 2021/8/31 15:06
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mViewBinding: ActivityMainBinding

    /**
     * Lazy 懒加载. 只有使用的时候才会注入实例
     */
    @Inject
    lateinit var mCarBooth: CarBooth

    /**
     * Provider 提供者. 每次都进行示例化. 保证每次的示例不同. 可以通过点击应用的字体观察到到 Driver 的名称是随机了
     */
    @Inject
    lateinit var mDriverProvider: Provider<Driver>

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
        // 虽然 CarShow 标记了 @Singleton. 但是因为 DaggerCarShowComponent 是在Activity中创建的则只是局部单例.
        // 如果需要全局单例子. 则需要将 DaggerCarShowComponent 保存到 Application 中达到全局单例的效果
        val carShowComponent = DaggerCarShowComponent.create()
        // 通过建造者模式创建MainComponent
        val daggerMainComponent = DaggerMainComponent.builder()
            .trafficPoliceComponent(trafficPoliceComponent)
            .carShowComponent(carShowComponent)
            .build()

        // 需要 SubComponent 中完成注入. 如果在 MainComponent 中 inject 则无法获取 'CarBooth'
        daggerMainComponent.boothComponent(BoothModule()).inject(this)

        ///endregion

        super.onCreate(savedInstanceState)
        // 绑定 ViewBinding.
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)

        // 点击车辆获取打印车辆信息
        // 多次点击可以观察到因为 Driver 是由 Provider 提供的则每次都出现了不同的实例.
        mViewBinding.tvActivityMainPrintCar.setOnClickListener {
            // 调用车辆展台的展示方法. 展示车辆.
            mCarBooth.booth(mDriverProvider.get())
        }
    }
}