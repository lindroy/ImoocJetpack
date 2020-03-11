package com.lindroy.imoocjetpack.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.lindroid.androidutilskt.extension.dp2px
import com.lindroid.androidutilskt.extension.logcat.dt
import com.lindroy.imoocjetpack.R
import com.lindroy.imoocjetpack.utils.AppConfig

/**
 * @author Lin
 * @date 2020/3/10
 * @function 自定义BottomBar
 */
@SuppressLint("RestrictedApi")
class AppBottomBar @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BottomNavigationView(
    context,
    attributeSet,
    defStyleAttr
) {
    private val icons = intArrayOf(
        R.drawable.icon_tab_home,
        R.drawable.icon_tab_sofa,
        R.drawable.icon_tab_publish,
        R.drawable.icon_tab_find,
        R.drawable.icon_tab_mine
    )


    init {
        val bottomBar = AppConfig.bottomBar
        val tabs = bottomBar.tabs
        val states = arrayOf<IntArray>(intArrayOf(android.R.attr.state_selected), intArrayOf())

        @SuppressLint("Range")
        val colors = intArrayOf(
            Color.parseColor(bottomBar.activeColor),
            Color.parseColor(bottomBar.inActiveColor)
        )
        val stateList = ColorStateList(states, colors)
        itemTextColor = stateList
        itemIconTintList = stateList
        //LABEL_VISIBILITY_LABELED:设置按钮的文本为一直显示模式
        //LABEL_VISIBILITY_AUTO:当按钮个数小于三个时一直显示，或者当按钮个数大于3个且小于5个时，被选中的那个按钮文本才会显示
        //LABEL_VISIBILITY_SELECTED：只有被选中的那个按钮的文本才会显示
        //LABEL_VISIBILITY_UNLABELED:所有的按钮文本都不显示
        labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        //设置选中的tab
        selectedItemId = bottomBar.selectTab

        tabs.forEach {
            if (it.enable.not()) {
                return@forEach
            }
            if (getItemId(it.pageUrl) < 0) {
                return@forEach
            }
            //将Item的Id与页面的Id关联起来
            val menuItem = menu.add(0, getItemId(it.pageUrl), it.index, it.title)
            menuItem.setIcon(icons[it.index])

        }
        //设置icon大小
        //BottomNavigationView为了排序会将里面的Item清除在添加，所以要先在前面添加好才能设置大小
        tabs.forEachIndexed { index, tab ->
            if (tab.enable.not()) {
                return@forEachIndexed
            }
            if (getItemId(tab.pageUrl) < 0) {
                return@forEachIndexed
            }
            //BottomNavigationView的第一个子View BottomNavigationMenuView是各个Tab的容器，可以通过它来获取各个Tab
            val menuView = getChildAt(0) as BottomNavigationMenuView
            val itemView = menuView.getChildAt(index) as BottomNavigationItemView
            //设置大小
            itemView.setIconSize(dp2px(tab.size))

            if (tab.title.isEmpty()) {
                itemView.setIconTintList(ColorStateList.valueOf(Color.parseColor(tab.tintColor)))
                //禁止浮动效果
                itemView.setShifting(false)
            }
        }
    }

    /**
     * 根据pageUrl从Destination中获取id
     */
    private fun getItemId(pageUrl: String) = AppConfig.desiConfig[pageUrl]?.id ?: -1

}