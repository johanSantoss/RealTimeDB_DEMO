package johan.santos.realtimedb_demo.ui.adminUser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import johan.santos.realtimedb_demo.MainActivity
import johan.santos.realtimedb_demo.R
import johan.santos.realtimedb_demo.databinding.AdminMainFragmentBinding
import johan.santos.realtimedb_demo.databinding.LoginFragmentBinding


class AdminMainFragment : Fragment() {

    private lateinit var binding : AdminMainFragmentBinding
    private lateinit var viewModel: AdminMainViewModel
    private lateinit var auth: FirebaseAuth

    companion object {
        fun newInstance() = AdminMainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.admin_main_fragment,
            container,
            false
        )
        auth = (activity as MainActivity).getAuth()

        binding.btnLogut.setOnClickListener {
            (activity as MainActivity).logutAndExit()
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AdminMainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}