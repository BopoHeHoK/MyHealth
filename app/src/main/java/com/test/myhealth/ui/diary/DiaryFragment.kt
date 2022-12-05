package com.test.myhealth.ui.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.myhealth.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment() {

    lateinit var binding: FragmentDiaryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiaryBinding.inflate(inflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = DiaryFragment()
    }
}