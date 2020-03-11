package com.lindroy.imoocjetpack.ui.publish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lindroy.imoocjetpack.R
import com.lindroy.libnavannotation.ActivityDestination

@ActivityDestination(pageUrl = "main/tabs/publish", needLogin = true)
class PublishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish)
    }
}
