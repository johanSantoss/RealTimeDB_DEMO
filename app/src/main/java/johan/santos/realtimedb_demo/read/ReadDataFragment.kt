package johan.santos.realtimedb_demo.read

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import johan.santos.realtimedb_demo.R
import johan.santos.realtimedb_demo.databinding.ReadFragmentBinding

class ReadDataFragment : Fragment() {

    companion object {
        fun newInstance() = ReadDataFragment()
    }

    private lateinit var viewModel: ReadDataViewModel
    private lateinit var binding : ReadFragmentBinding
    private lateinit var database : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ReadFragmentBinding.inflate(layoutInflater)

        binding.readdataBtn.setOnClickListener {

            val userName : String = binding.etusername.text.toString()
            if  (userName.isNotEmpty()){

                readData(userName)

            }else{

                Toast.makeText(activity,"PLease enter the Username", Toast.LENGTH_SHORT).show()

            }

        }

        return binding.root
    }

    private fun readData(userName: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(userName).get().addOnSuccessListener {

            if (it.exists()){

                val firstname = it.child("firstName").value
                val lastName = it.child("lastName").value
                val age = it.child("age").value
                Toast.makeText(activity,"Successfuly Read",Toast.LENGTH_SHORT).show()
                binding.etusername.text.clear()
                binding.tvFirstName.text = firstname.toString()
                binding.tvLastName.text = lastName.toString()
                binding.tvAge.text = age.toString()

            }else{
                Toast.makeText(activity,"User Doesn't Exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(activity,"Failed",Toast.LENGTH_SHORT).show()
        }



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReadDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}