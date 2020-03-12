package com.lindroy.imoocjetpack

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lindroy.imoocjetpack.utils.NavGraphBuilder
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Lin
 * @date 2020/3/8
 * @function
 * @Description
 * http://123.56.232.18:8080/serverdemo/swagger-ui.html#/comment-controller
 */
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    /*private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }*/

    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)

        val hostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        navController = NavHostFragment.findNavController(hostFragment!!)

        navView.setupWithNavController(navController)

        NavGraphBuilder.build(this, navController,hostFragment!!.id)

        navView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        navController.navigate(item.itemId)
        //返回为true时表示按钮选中，需要着色和放缩，这里需要根据是否有标题文字来判断
        return item.title.isNotEmpty()
    }

}
