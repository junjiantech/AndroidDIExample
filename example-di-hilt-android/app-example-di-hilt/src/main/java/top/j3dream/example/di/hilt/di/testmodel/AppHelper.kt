package top.j3dream.example.di.hilt.di.testmodel

import android.util.Log

/**
 * @author Jia Junjian
 * @since 2021/9/1 17:57
 */
class AppHelper constructor() {

    companion object {

        private const val TAG = "AppHelper"
    }

    /**
     * 生成一个随机的 code.
     */
    private val mCode: Int by lazy { (0..100).random() }

    fun printAppHelperCode() {
        Log.e(TAG, "AppHelper Code: $mCode")
    }
}