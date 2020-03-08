package com.lindroy.libnavannotation

import java.lang.annotation.ElementType
import java.lang.annotation.Target

/**
 * @author Lin
 * @date 2020/3/8
 * @function
 */


@Target(ElementType.TYPE)
annotation class FragmentDestination(
   val pageUrl: String ,
   val needLogin: Boolean = false,
   val asStarter: Boolean = false
)
