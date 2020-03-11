package com.lindroy.imoocjetpack.utils

import android.content.ComponentName
import androidx.fragment.app.FragmentActivity
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphNavigator
import androidx.navigation.fragment.FragmentNavigator

/**
 * @author Lin
 * @date 2020/3/9
 * @function
 */
object NavGraphBuilder {
    fun build(activity:FragmentActivity,controller:NavController){
        val provider = controller.navigatorProvider
        val fragmentNavigator = provider.getNavigator<FragmentNavigator>(FragmentNavigator::class.java)
        val activityNavigator = provider.getNavigator<ActivityNavigator>(ActivityNavigator::class.java)
        val navGraph = NavGraph(NavGraphNavigator(provider))
        val destConfig = AppConfig.desiConfig
        destConfig.values.forEach {
            if (it.isFragment){
                navGraph.addDestination(fragmentNavigator.createDestination().apply {
                    className = it.className
                    id = it.id
                    addDeepLink(it.pageUrl)
                })
            }else{
                navGraph.addDestination(activityNavigator.createDestination().apply {
                    id = it.id
                    addDeepLink(it.pageUrl)
                    setComponentName(ComponentName(AppGlobal.application.packageName,it.className))
                })
            }
            if(it.asStarter){
                navGraph.startDestination = it.id
            }
        }
        controller.graph = navGraph

    }
}