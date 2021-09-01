package top.j3dream.example.di.hilt.di.testmodel

import javax.inject.Inject
import javax.inject.Named

/**
 * @author Jia Junjian
 * @since 2021/9/1 17:02
 */
class User @Inject constructor(
    private val _jacket: IJacket,
    @Named("Cowboy")
    private val _cap: ICap
) {

    // 用户穿着的夹克上衣
    val jacket get() = _jacket

    val cap get() = _cap
}