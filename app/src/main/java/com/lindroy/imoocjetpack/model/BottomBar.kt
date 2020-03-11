package com.lindroy.imoocjetpack.model

/**
 * @author Lin
 * @date 2020/3/10
 * @function 底部栏信息
 */
data class BottomBar(
    var activeColor: String = "",   //按钮被选中的颜色
    var inActiveColor: String = "", //按钮常规颜色
    var selectTab: Int = 0,
    var tabs: List<TabBean> = listOf()
){
    data class TabBean(
        var enable: Boolean = false,
        var index: Int = 0,
        var pageUrl: String = "",
        var size: Int = 0,
        var tintColor: String = "",
        var title: String = ""
    )
}

