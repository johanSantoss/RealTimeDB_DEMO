package johan.santos.realtimedb_demo.ui.businessUser.manageRates

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import johan.santos.realtimedb_demo.R

class ManageRatesFragment : Fragment() {

    companion object {
        fun newInstance() = ManageRatesFragment()
    }

    private lateinit var viewModel: ManageRatesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.manage_rates_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ManageRatesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}