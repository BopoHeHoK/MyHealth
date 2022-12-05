package com.test.myhealth.ui.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.myhealth.databinding.FragmentScheduleBinding

class ScheduleFragment : Fragment() {

    lateinit var binding: FragmentScheduleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScheduleBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ScheduleFragment()
    }
}