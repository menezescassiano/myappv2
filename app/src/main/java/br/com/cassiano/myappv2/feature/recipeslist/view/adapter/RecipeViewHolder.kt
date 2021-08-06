package br.com.cassiano.myappv2.feature.recipeslist.view.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.cassiano.myappv2.databinding.RecipesListItemBinding
import br.com.cassiano.myappv2.domain.model.Recipe
import br.com.cassiano.myappv2.util.ImageUtil.setImageUrl

class RecipeViewHolder(private val binding: RecipesListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Recipe) {

        this.binding.apply {
            item.run {
                title.text = name
                setImageUrl(ivImage, thumb)
            }
            executePendingBindings()
        }
    }
}