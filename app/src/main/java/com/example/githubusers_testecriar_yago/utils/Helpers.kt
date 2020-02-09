package com.example.githubusers_testecriar_yago.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.githubusers_testecriar_yago.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class Helpers {

    companion object {

        @BindingAdapter("profileImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String?) {
            Picasso.get()
                .load(imageUrl)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .placeholder(R.drawable.ic_github_placeholder)
                .into(view)
        }
    }
}