package com.test.myhealth.app.presentation.screen.tab.profile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : Fragment() {

    @Inject
    lateinit var profileViewModelFactory: ProfileViewModelFactory

    private lateinit var binding: FragmentProfileBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectProfileFragment(
            profileFragment = this
        )
        profileViewModel = ViewModelProvider(
            owner = this,
            factory = profileViewModelFactory
        )[ProfileViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toUserSetup(view)
        toBiometrics(view)
        toGetPremium(view)
        logout(view)
        observeUser()
    }

    @SuppressLint("SetTextI18n")
    private fun observeUser() {
        val user = profileViewModel.observerUser(profileViewModel.getUserId())
        binding.apply {
            username.text = "${user.lastName} ${user.firstName}"
        }
    }

    private fun toUserSetup(view: View) {
        binding.linear1.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_userSetupFragment)
        }
    }

    private fun toBiometrics(view: View) {
        binding.linear2.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_biometricsFragment)
        }
    }

    private fun toGetPremium(view: View) {

    }

    private fun logout(view: View) {
        binding.linear4.setOnClickListener {
            profileViewModel.deleteId()
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_singInFragment)
        }
    }
}