package com.lindroy.imoocjetpack.ui.my


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lindroy.imoocjetpack.R
import com.lindroy.libnavannotation.FragmentDestination

/**
 * A simple [Fragment] subclass.
 */

@FragmentDestination(pageUrl = "main/tabs/my",asStarter = false)
class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false)
    }


}
