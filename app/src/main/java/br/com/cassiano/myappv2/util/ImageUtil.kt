package br.com.cassiano.myappv2.util

import android.widget.ImageView
import br.com.cassiano.myappv2.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object ImageUtil {

    fun setImageUrl(imgView: ImageView, imgUrl: String?, isPicture: Boolean = false) {
        val placeHolder = when {
            isPicture -> R.drawable.recipe
            else -> R.drawable.ic_photo_black
        }

        imgUrl?.let {
            Glide.with(imgView.context).load(imgUrl)
                .apply(RequestOptions().placeholder(placeHolder))
                .into(imgView)
        }
    }

}