package Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding


class login_Fragment : Fragment() {

   private val minPass=6
   private val maxPass=12
private lateinit var binding:FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
         binding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        binding.LoginButton.setOnClickListener {checkLogin()}
        binding.CreateNewLoginButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(login_FragmentDirections.actionLoginFragmentToWelcomeFragment()))
        return binding.root

    }

    private fun checkLogin(){
    if(binding.editTextTextEmailAddress.text.toString().trim().isEmpty() ||
        binding.editTextTextPassword.text.toString().trim().isEmpty() ){
        Toast.makeText(context,"Email or Password is empty !!",Toast.LENGTH_SHORT).show()
    }
        else if (binding.editTextTextPassword.text.toString().trim().length <minPass
        || binding.editTextTextPassword.text.toString().trim().length > maxPass)
    {
            Toast.makeText(context,"Password must be between 6 and 12 characters",Toast.LENGTH_SHORT).show()
        }
     else findNavController().navigate(R.id.action_login_Fragment_to_welcome_Fragment)

    }


}


