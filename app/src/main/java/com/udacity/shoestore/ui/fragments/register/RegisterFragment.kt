package com.udacity.shoestore.ui.fragments.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentRegisterBinding
import com.udacity.shoestore.models.User
import com.udacity.shoestore.ui.activity.main.MainActivity
import com.udacity.shoestore.util.UserConstant.USER_KEY
import com.udacity.shoestore.viewModel.activity.LoginAndRegisterViewModel


class RegisterFragment : Fragment() {
    private val binding by lazy { FragmentRegisterBinding.inflate(layoutInflater) }
    private lateinit var viewModel: LoginAndRegisterViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this@RegisterFragment).get(LoginAndRegisterViewModel::class.java)
        bindUI()
        observeState()
    }

    private fun bindUI(): Unit = with(binding) {
        lifecycleOwner = this@RegisterFragment

        textViewHaveAccount.setOnClickListener {
            val action =RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            it.findNavController().navigate(action)
        }

        registerButton.setOnClickListener {
            val email = emailTextField.editText?.text.toString()
            val password = passwordInputField.editText?.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                viewModel.register(email, password)
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
                val user=User(email,password)
                val intent = Intent(requireContext(), MainActivity::class.java)
                intent.putExtra(USER_KEY,user)
                activity?.startActivity(intent)
                activity?.finish()
            } else {
                Toast.makeText(requireContext(), "User Not Found", Toast.LENGTH_SHORT).show()
            }
        })

    }


}