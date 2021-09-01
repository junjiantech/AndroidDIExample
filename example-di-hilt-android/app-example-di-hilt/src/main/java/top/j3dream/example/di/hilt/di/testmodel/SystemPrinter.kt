package top.j3dream.example.di.hilt.di.testmodel

import android.util.Log

/**
 * @author Jia Junjian
 * @since 2021/9/1 17:17
 */
class SystemPrinter constructor(private val tag: String = "Android") {

    /**
     * 打印用户信息
     * @param user user
     */
    fun printUserInfo(user: User) {
        Log.e(
            tag, String.format(
                "User: 我穿着[%s]上衣, 戴着[%s]帽子",
                user.jacket.jacketTypeName(),
                user.cap.capTypeName()
            )
        )
    }
}