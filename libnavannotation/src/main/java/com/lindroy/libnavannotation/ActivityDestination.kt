package com.lindroy.libnavannotation


/**
 * @author Lin
 * @date 2020/3/8
 * @function
 */

@kotlin.annotation.Target(AnnotationTarget.CLASS)
annotation class ActivityDestination(
    val pageUrl: String ,
    val needLogin: Boolean = false,
    val asStarter: Boolean = false
)