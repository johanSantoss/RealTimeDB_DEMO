package johan.santos.realtimedb_demo.update

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
import johan.santos.realtimedb_demo.databinding.RegistreDataFragmentBinding
import johan.santos.realtimedb_demo.databinding.UpdateDataFragmentBinding

class UpdateDataFragment : Fragment() {

    companion object {
        fun newInstance() = UpdateDataFragment()
    }

    private lateinit var viewModel: UpdateDataViewModel
    private lateinit var binding : UpdateDataFragmentBinding
    private lateinit var database : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UpdateDataFragmentBinding.inflate(layoutInflater)

        binding.updateBtn.setOnClickListener {

            val userName = binding.userName.text.toString()
            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastname.text.toString()
            val age = binding.age.text.toString()

            updateData(userName,firstName,lastName,age)

        }


        return binding.root
    }

    private fun updateData(userName: String, firstName: String, lastName: String, age: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String,String>(
            "firstName" to firstName,
            "lastName" to lastName,
            "age" to age
        )

        database.child(userName).updateChildren(user).addOnSuccessListener {

            binding.userName.text.clear()
            binding.firstName.text.clear()
            binding.lastname.text.clear()
            binding.age.text.clear()
            Toast.makeText(activity,"Successfuly Updated", Toast.LENGTH_SHORT).show()


        }.addOnFailureListener{

            Toast.makeText(activity,"Failed to Update", Toast.LENGTH_SHORT).show()

        }}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UpdateDataViewModel::class.java)
        // TODO: Use the ViewModel
    }

}