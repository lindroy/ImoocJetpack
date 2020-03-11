package com.lindroy.imoocjetpack.ui.sofa


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
 * @function 沙发页面
 * @Description
 */
@FragmentDestination(pageUrl = "main/tabs/sofa",asStarter = false)
class SofaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sofa, container, false)
    }


}
