package com.muratcay.rick_and_morty_multi_module_app.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.muratcay.rick_and_morty_multi_module_app.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GlideModule {

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) =
        Glide.with(context).setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.loading_img)
                .error(R.drawable.ic_running_with_errors)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
        )
}

// diskCacheStrategy(DiskCacheStrategy.DATA)  Görüntü verilerini önbelleğe almak için kullanılır(Dönüştürülen görüntüyü almaz).