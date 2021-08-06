package br.com.cassiano.myappv2.feature.recipeslist.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.cassiano.myappv2.R
import br.com.cassiano.myappv2.databinding.FragmentDetailsBinding
import br.com.cassiano.myappv2.extension.activityViewModel
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding

    private val viewModel: DetailsViewModel by viewModel()
    private val flowViewModel: MainViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        /*setupViewModel()
        setupListener()*/

        return binding.root
    }

}