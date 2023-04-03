package Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.ShoeViewModel
import com.example.shoestore.databinding.FragmentShoeDetailBinding


class ShoeDetail_Fragment : Fragment() {
private lateinit var viewmodel:ShoeViewModel
private lateinit var binding:FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        viewmodel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding.view=viewmodel

        binding.cancelButton.setOnClickListener { findNavController().navigateUp() }
       binding.SaveButton.setOnClickListener {
          val shname = viewmodel.shoename.value.toString()
           val size =viewmodel.shoesize.value.toString()
           val company =viewmodel.comapny.value.toString()
           val disc =viewmodel.descriptions.value.toString()
           if(binding.shoeNameEditText.text.isNullOrEmpty()|| binding.shoeSizeEditText.text.isNullOrEmpty() ||binding.companyEditText.text.isNullOrEmpty() || binding.DescriptionEditText.text.isNullOrEmpty())
           {
               Toast.makeText(context,"Write the data Correctly",Toast.LENGTH_SHORT).show()
           }
           else{

           viewmodel.onSave(shname, company,size,disc)
           findNavController().navigate(R.id.action_shoeDetail_Fragment_to_shoeList)
               Toast.makeText(context,"Added ",Toast.LENGTH_SHORT).show()
       }
       }

        return binding.root

    }


}


