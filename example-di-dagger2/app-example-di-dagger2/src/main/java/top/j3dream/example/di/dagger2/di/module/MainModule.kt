package top.j3dream.example.di.dagger2.di.module

import dagger.Module
import dagger.Provides
import top.j3dream.example.di.dagger2.di.testmodel.Car
import top.j3dream.example.di.dagger2.di.testmodel.Engine
import top.j3dream.example.di.dagger2.di.testmodel.TrafficPolice

/**
 * - 文件描述: MainActivity DI Module
 * @author Jia Junjian
 * @since 2021/8/31 14:50
 */
@Module
class MainModule {

    /**
     * 为 Main Activity 提供Car对象注入
     * @param engine 注入的发动机
     * @param trafficPolice 交通警察用于发放拍照
     * @param tire 轮胎
     * @param frame 车架/框架
     */
    @Provides
    fun provideMainTestCar(engine: Engine, trafficPolice: TrafficPolice): Car {
        // 生产一个 Car 对象提供给 MainActivity 使用
        return object : Car(engine, trafficPolice.generatePlateNumber()) {
            override fun getBrand(): String = "KIA"

            override fun getModel(): String = "KX3"
        }
    }
}