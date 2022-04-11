package johan.santos.realtimedb_demo.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import johan.santos.realtimedb_demo.R
import johan.santos.realtimedb_demo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding : MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )

        binding.btnRegistre.setOnClickListener {
            // generar action al directions to Registre Fragment
            val action = MainFragmentDirections.actionMainFragmentToRegistreDataFragment()
            // ejecutar navigate to registre con el "action" generado en la parte superior
            NavHostFragment.findNavController(this).navigate(action)
        }
        binding.btnRead.setOnClickListener {
            // generar action al directions to Registre Fragment
            val action = MainFragmentDirections.actionMainFragmentToReadDataFragment2()
            // ejecutar navigate to registre con el "action" generado en la parte superior
            NavHostFragment.findNavController(this).navigate(action)
        }
        binding.btnUpdate.setOnClickListener {
            // generar action al directions to Registre Fragment
            val action = MainFragmentDirections.actionMainFragmentToUpdateDataFragment()
            // ejecutar navigate to registre con el "action" generado en la parte superior
            NavHostFragment.findNavController(this).navigate(action)
        }


        return binding.root
    }

}