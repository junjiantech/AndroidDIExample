package top.j3dream.example.di.dagger2.di.component

import dagger.Component
import top.j3dream.example.di.dagger2.di.module.TrafficPoliceModule
import top.j3dream.example.di.dagger2.di.testmodel.TrafficPolice

/**
 * @author Jia Junjian
 * @since 2021/8/31 18:12
 */
@Component(modules = [TrafficPoliceModule::class])
interface TrafficPoliceComponent {

    fun getTrafficPolice(): TrafficPolice
}