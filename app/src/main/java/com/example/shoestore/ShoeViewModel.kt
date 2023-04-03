package com.example.shoestore

import Fragments.ShoeDetail_Fragment
import Fragments.ShoeDetail_FragmentDirections
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentShoeDetailBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class ShoeViewModel :ViewModel() {


 //declaring the mutable list because it is changeable

  var shoelist = MutableLiveData<MutableList<ShoeDetail>>()

 val shoename=MutableLiveData<String>()
 val shoesize=MutableLiveData<String>()
 val descriptions=MutableLiveData<String>()
 val comapny=MutableLiveData<String>()

 init {
     shoelist.value=ArrayList()
 }


 //The saving method to get from the detail Fragment

 fun onSave(shoeName: String, shcomp: String, shsize: String, shdisc: String) {
  val newShoe = ShoeDetail(shoeName, shcomp, shsize, shdisc)
   shoelist.value?.add(newShoe)
   shoelist.value = shoelist.value
 }


}
