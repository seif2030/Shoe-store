package Fragments

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.ShoeDetail
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.ShoeViewModel
import com.example.shoestore.databinding.DetailsBinding

class ShoeList : Fragment() {
private lateinit var binding:FragmentShoeListBinding
private lateinit var viewmodel:ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment & the BINDING
         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListDirections.actionShoeListToShoeDetailFragment()))

        viewmodel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        viewmodel.shoelist.observe(viewLifecycleOwner){ view_Shoe_Item(it) }

        binding.lifecycleOwner=viewLifecycleOwner


        return binding.root


    }

//Viewing the shoe items in the Edit texts in the Shoe List Fragment &
// USING THE Addview Method to create new layout

private fun view_Shoe_Item(viewdata:List<ShoeDetail>){
    viewdata.forEach{

val bindingView=DetailsBinding.inflate(LayoutInflater.from(requireContext()) ,binding.listLayoutIN,false)
        with(bindingView){
            shoeCompany.text = it.company
            shoeDescription.text = it.description
            shoeName.text = it.shoeName
            shoeSize.text = it.shoeSize
        }
        binding.listLayoutIN.addView(bindingView.root)
    }

}
    //Creating THE MENU

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // The usage of an interface lets you inject your own implementation
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.logout_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                findNavController().navigate(ShoeListDirections.actionShoeListToLoginFragment())
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }






}

