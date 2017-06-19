package com.jun.kotlinlearn.fragment


import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jun.kotlinlearn.R


/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {

    companion object {
        fun newInstance() : AboutFragment {
            val fragment = AboutFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_about_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
