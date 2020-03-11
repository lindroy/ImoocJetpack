package com.lindroy.imoocjetpack.utils

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import com.lindroy.imoocjetpack.model.BottomBar
import com.lindroy.imoocjetpack.model.Destination
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

/**
 * @author Lin
 * @date 2020/3/9
 * @function
 */
object AppConfig {

    val desiConfig:HashMap<String,Destination> by  lazy {
        JSON.parseObject(parseFile("destination.json"), object :TypeReference<HashMap<String,Destination>>(){} )
    }


    val bottomBar:BottomBar by lazy {
        JSON.parseObject(parseFile("main_tabs_config.json"), object :TypeReference<BottomBar>(){} )
    }

    /**
     * 解析文件
     */
    private fun parseFile(fileName: String): String {
        val assets = AppGlobal.application.assets
        var `is`: InputStream? = null
        var br: BufferedReader? = null
        val builder = StringBuilder()
        try {
            `is` = assets.open(fileName)
            br = BufferedReader(InputStreamReader(`is`!!))
            var line: String? = null
            while (br.readLine().apply { line = this } != null) {
                builder.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                `is`?.close()
                br?.close()
            } catch (e: Exception) {

            }

        }

        return builder.toString()
    }
}