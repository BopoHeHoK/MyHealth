package com.test.myhealth.app.presentation.screen.tab.profile.menu.user_setup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentUserSetupBinding
import com.test.myhealth.domain.model.User
import java.util.regex.Pattern
import javax.inject.Inject

class UserSetupFragment : Fragment() {

    @Inject
    lateinit var userSetupViewModelFactory: UserSetupViewModelFactory

    private lateinit var binding: FragmentUserSetupBinding
    private lateinit var userSetupViewModel: UserSetupViewModel

    private var email = ""
    private var phoneNumber = ""
    private var firstName = ""
    private var lastName = ""
    private var roleId = 1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectUserSetupFragment(
            userSetupFragment = this
        )
        userSetupViewModel = ViewModelProvider(
            owner = this,
            factory = userSetupViewModelFactory
        )[UserSetupViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserSetupBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUser()
        onArrowBackClick(view)
        openChangePassword()
        closeChangePassword()
        saveChanges(view)
    }

    private fun observeUser() {
        binding.apply {
            userSetupViewModel.apply {
                val user = observerUser(getUserId())
                roleId = user.roleId
                user.firstName?.let {
                    etFirstName.hint = it
                    firstName = it
                }
                user.lastName?.let {
                    etLastName.hint = it
                    lastName = it
                }
                user.email?.let {
                    etEmail.hint = it
                    email = it
                }
                user.phoneNumber?.let {
                    etPhoneNumber.hint = it
                    phoneNumber = it
                }
            }
        }
    }

    private fun onArrowBackClick(view: View) {
        binding.arrowBack.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }

    private fun openChangePassword() {
        binding.apply {
            changePassword.setOnClickListener {
                changePassword.visibility = View.GONE
                clChangePassword.visibility = View.VISIBLE
            }
        }
    }

    private fun closeChangePassword() {
        binding.apply {
            close.setOnClickListener {
                changePassword.visibility = View.VISIBLE
                clChangePassword.visibility = View.GONE
            }
        }
    }

    private fun isValidString(str: String): Boolean {
        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
    }

    private fun checkFieldValues() {
        binding.apply {
            if (etEmail.text.toString().isNotBlank()) {
                email = etEmail.text.toString()
            }
            if (etPhoneNumber.text.toString().isNotBlank()) {
                phoneNumber = etPhoneNumber.text.toString()
            }
            if (etFirstName.text.toString().isNotBlank()) {
                firstName = etFirstName.text.toString()
            }
            if (etLastName.text.toString().isNotBlank()) {
                lastName = etLastName.text.toString()
            }
        }
    }

    private fun saveChanges(view: View) {
        binding.apply {
            save.setOnClickListener {
                checkFieldValues()
                emailError.visibility = View.GONE
                userSetupViewModel.apply {
                    if (etEmail.text.toString()
                            .isNotBlank() && !isValidString(etEmail.text.toString())
                    ) {
                        emailError.visibility = View.VISIBLE
                    } else {
                        val user = User(
                            id = getUserId(),
                            email = email,
                            phoneNumber = phoneNumber,
                            firstName = firstName,
                            lastName = lastName,
                            roleId = roleId,
                        )
                        upsertUser(user = user)
                        Navigation.findNavController(view).popBackStack()
                    }
                }
            }
        }
    }
}