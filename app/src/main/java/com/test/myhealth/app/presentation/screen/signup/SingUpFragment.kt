package com.test.myhealth.app.presentation.screen.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentSingUpBinding
import com.test.myhealth.domain.model.Register
import java.util.regex.Pattern
import javax.inject.Inject

class SingUpFragment : Fragment() {

    @Inject
    lateinit var singUpViewModelFactory: SingUpViewModelFactory

    private lateinit var binding: FragmentSingUpBinding
    private lateinit var signUpViewModel: SingUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectSingUpFragment(
            signUpFragment = this
        )
        signUpViewModel = ViewModelProvider(
            owner = this,
            factory = singUpViewModelFactory
        )[SingUpViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingUpBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toSignIn(view)
        save(view)
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

    private fun toSignIn(view: View) {
        binding.tvToLogin.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }

    private fun save(view: View) {
        binding.btnRegister.setOnClickListener {
            if (checkValues()) {
                registerObserve(view)
            }
        }
    }

    private fun checkValues(): Boolean {
        binding.apply {
            emailError.visibility = View.GONE
            firstNameError.visibility = View.GONE
            lastNameError.visibility = View.GONE
            passwordError.visibility = View.GONE
            if (etEmail.text.toString().isBlank()) {
                emailError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.empty_field_error)
                return false
            }
            if (etEmail.text.toString().isNotBlank() && !isValidString(etEmail.text.toString())) {
                emailError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.email_format_error)
                return false
            }
            if (etFirstName.text.toString().isBlank()) {
                firstNameError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.empty_field_error)
                return false
            }
            if (etLastName.text.toString().isBlank()) {
                lastNameError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.empty_field_error)
                return false
            }
            if (etPassword.text.toString().isBlank()) {
                passwordError.visibility = View.VISIBLE
                emailError.text = resources.getString(R.string.empty_field_error)
                return false
            }
            if (etPassword.text.toString().isNotBlank() && etPassword.text.toString().length <= 6) {
                passwordError.visibility = View.VISIBLE
                passwordError.text = resources.getString(R.string.password_length_error)
                return false
            }
            if (etRepeatPassword.text.toString().isNotBlank()
                && etPassword.text.toString() != etRepeatPassword.text.toString()
            ) {
                passwordError.visibility = View.VISIBLE
                passwordError.text = resources.getString(R.string.repeat_password_error)
                return false
            }
        }
        return true
    }

    private fun registerObserve(view: View) {
        binding.apply {
            signUpViewModel.apply {
                val register = Register(
                    email = etEmail.text.toString(),
                    first_name = etFirstName.text.toString(),
                    last_name = etLastName.text.toString(),
                    password = etPassword.text.toString()
                )
                getToken(register)
                observerToken().observe(viewLifecycleOwner) { token ->
                    setUserId()
                    if (getUserId() != 0L) {
                        Navigation.findNavController(view)
                            .navigate(R.id.action_singUpFragment_to_splashFragment)
                    }
                }
                llError.visibility = View.VISIBLE
                error.text = resources.getString(R.string.email_exist_error)
                save(view)
            }
        }
    }
}