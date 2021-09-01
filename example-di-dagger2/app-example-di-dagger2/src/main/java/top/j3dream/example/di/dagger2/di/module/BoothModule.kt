package top.j3dream.example.di.dagger2.di.module

import dagger.Module
import dagger.Provides
import top.j3dream.example.di.dagger2.di.testmodel.Car
import top.j3dream.example.di.dagger2.di.testmodel.CarBooth

/**
 * @author Jia Junjian
 * @since 2021/9/1 08:54
 */
@Module
class BoothModule {

    /**
     * 提供车辆站台
     * @param car 父级 MainComponent 中的 MainModule 中提供的
     * @return 该传入 car 的站台
     */
    @Provides
    fun provideCarBooth(car: Car): CarBooth = CarBooth(car)
}