package com.udacity.shoestore.ui.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.User
import com.udacity.shoestore.viewModel.activity.LoginAndRegisterViewModel


class LoginFragment : Fragment() {


    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private lateinit var viewModel: LoginAndRegisterViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this@LoginFragment).get(LoginAndRegisterViewModel::class.java)
        bindUI()
        observeState()
    }

    private fun bindUI(): Unit = with(binding) {
        lifecycleOwner = this@LoginFragment
        setHasOptionsMenu(false)
        textViewNoAccount.setOnClickListener {
            Toast.makeText(requireContext(), "Registry", Toast.LENGTH_SHORT).show()
        }

        loginButton.setOnClickListener {
            val email = emailTextField.editText?.text.toString()
            val password = passwordInputField.editText?.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                viewModel.login(email, password)
            } else {
                emailTextField.error = "Email required"
                passwordInputField.error = "Password required"
            }
        }
    }


    private fun observeState(): Unit = with(viewModel) {
        stateUserLogin.observe(viewLifecycleOwner, { state ->
            if (state) {
                val email = binding.emailTextField.editText?.text.toString()
                val password = binding.passwordInputField.editText?.text.toString()
                val user = User(email, password)
                val action = LoginFragmentDirections.actionLoginFragmentToFragmentWelcome(user)
                requireView().findNavController().navigate(action)

            } else {
                Toast.makeText(requireContext(), "User Not Found", Toast.LENGTH_SHORT).show()
            }
        })

    }

}