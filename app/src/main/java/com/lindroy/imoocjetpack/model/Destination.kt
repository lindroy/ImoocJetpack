package com.lindroy.imoocjetpack.model

/**
 * @author Lin
 * @date 2020/3/9
 * @function
 */
data class Destination(
    var asStarter: Boolean = false,
    var className: String = "",
    var id: Int = 0,
    var isFragment: Boolean = false,
    var needLogin: Boolean = false,
    var pageUrl: String = ""
)