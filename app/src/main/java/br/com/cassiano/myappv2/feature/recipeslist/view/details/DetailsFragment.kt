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
import br.com.cassiano.myappv2.util.ImageUtil.setImageUrl

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding

    private val flowViewModel: MainViewModel by activityViewModel()
    private val selectedRecipe by lazy { flowViewModel.selectedRecipe }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        setupBinding()

        return binding.root
    }

    private fun setupBinding() {
        binding.apply {
            selectedRecipe?.run {
                setImageUrl(ivImage, image)
                tvTitle.text = name
                tvHeadline.text = headline
                tvDesctiption.text = description
            }
        }
    }

}