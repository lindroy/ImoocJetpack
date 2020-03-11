package com.lindroy.imoocjetpack.ui.find


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lindroy.imoocjetpack.R
import com.lindroy.libnavannotation.FragmentDestination

/**
 * @author Lin
 * @date 2020/3/11
 * @function 发现
 * @Description
 */
@FragmentDestination(pageUrl = "main/tabs/find",asStarter = false)
class FindFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false)
    }


}
