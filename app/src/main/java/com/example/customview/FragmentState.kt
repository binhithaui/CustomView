package com.example.customview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_fragment.*

class FragmentState : Fragment() {
    private var position: Int = -1
    fun setPosition(position: Int):FragmentState {
        this.position = position
        return this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when (position) {
            0 -> {
                mLayoutRoot.setBackgroundColor(ContextCompat.getColor(activity!!, android.R.color.holo_red_dark))
            }
            1 -> {
                mLayoutRoot.setBackgroundColor(ContextCompat.getColor(activity!!, android.R.color.holo_green_dark))
            }
            2 -> {
                mLayoutRoot.setBackgroundColor(ContextCompat.getColor(activity!!, android.R.color.holo_blue_dark))
            }
        }
    }
}