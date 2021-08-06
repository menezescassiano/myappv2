package br.com.cassiano.myappv2.feature.recipeslist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import br.com.cassiano.myappv2.R
import br.com.cassiano.myappv2.databinding.RecipesListItemBinding
import br.com.cassiano.myappv2.domain.model.Recipe

class RecipesAdapter(private val list: List<Recipe>) : RecyclerView.Adapter<RecipeViewHolder>() {

    val selectedRecipe: MutableLiveData<Recipe> = MutableLiveData()
    lateinit var binding: RecipesListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false) as RecipesListItemBinding
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = list[position]

        holder.apply {
            bind(item)
            itemView.setOnClickListener {
                selectedRecipe.value = item
            }
        }
    }

    override fun getItemCount() = list.count()

    override fun getItemViewType(position: Int) = R.layout.recipes_list_item
}