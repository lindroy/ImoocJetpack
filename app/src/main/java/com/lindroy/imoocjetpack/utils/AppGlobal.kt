package com.lindroy.imoocjetpack.utils

import android.annotation.SuppressLint
import android.app.Application

/**
 * @author Lin
 * @date 2020/3/9
 * @function
 * 这种方式获取全局的Application 是一种拓展思路。
 * <p>
 * 对于组件化项目,不可能把项目实际的Application下沉到Base,而且各个module也不需要知道Application真实名字
 * <p>
 * 这种一次反射就能获取全局Application对象的方式相比于在Application#OnCreate保存一份的方式显示更加通用了
 */
@SuppressLint("PrivateApi")
object AppGlobal{

    val application by lazy {
        //Todo(这些异常如何抛出呢？)
        /*try {
            Class.forName("android.app.ActivityThread")
                .getMethod("currentApplication")
                .invoke(null) as Application
        }catch (e:IllegalAccessException){
            e.printStackTrace()
        }catch (e:InvocationTargetException){
            e.printStackTrace()
        }catch (e:NoSuchMethodException){
            e.printStackTrace()
        }catch (e:ClassNotFoundException){
            e.printStackTrace()
        }*/

        Class.forName("android.app.ActivityThread")
            .getMethod("currentApplication")
            .invoke(null) as Application

    }
}