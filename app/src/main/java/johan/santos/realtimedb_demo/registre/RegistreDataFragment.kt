package johan.santos.realtimedb_demo.registre

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import johan.santos.realtimedb_demo.R
import johan.santos.realtimedb_demo.databinding.MainFragmentBinding
import johan.santos.realtimedb_demo.databinding.RegistreDataFragmentBinding
import johan.santos.realtimedb_demo.model.User

class RegistreDataFragment : Fragment() {

    companion object {
        fun newInstance() = RegistreDataFragment()
    }

    private lateinit var viewModel: RegistreDataViewModel
    private lateinit var binding : RegistreDataFragmentBinding
    private lateinit var database : DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = RegistreDataFragmentBinding.inflate(layoutInflater)

        binding.registerBtn.setOnClickListener {

            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            val age = binding.age.text.toString()
            val userName = binding.userName.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(firstName,lastName,age,userName)
            database.child(userName).setValue(User).addOnSuccessListener {

                binding.firstName.text.clear()
                binding.lastName.text.clear()
                binding.age.text.clear()
                binding.userName.text.clear()

                Toast.makeText(activity,"Successfully Saved", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{

                Toast.makeText(activity,"Failed", Toast.LENGTH_SHORT).show()


            }


        }


        return binding.root
    }



}