package top.j3dream.example.di.dagger2.di.testmodel

import javax.inject.Inject

/**
 * 驾驶员的描述
 * @author Jia Junjian
 * @since 2021/8/31 16:35
 */
class Driver @Inject constructor() {

    /**
     * 驾驶员的名称
     */
    fun getDriverName() = "小贾${(0..9).random()}"
}