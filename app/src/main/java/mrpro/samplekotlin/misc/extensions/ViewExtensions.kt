@file:JvmName("ViewExtensionsUtils")

package mrpro.samplekotlin.misc.extensions

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.StreamEncoder
import com.bumptech.glide.load.resource.file.FileToStreamDecoder
import com.caverock.androidsvg.SVG
import mrpro.samplekotlin.R
import mrpro.samplekotlin.misc.glide.SvgDecoder
import mrpro.samplekotlin.misc.glide.SvgDrawableTranscoder
import mrpro.samplekotlin.misc.glide.SvgSoftwareLayerSetter
import java.io.InputStream


/**
 * Created by Andrey on 11/29/16.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Glide.with(context)
                .load(R.mipmap.ic_launcher).into(this)
    } else if(imageUrl.endsWith("svg")){
        val uri = Uri.parse(imageUrl)
        getGlideSvgRequestBuilder(context)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                // SVG cannot be serialized so it's not worth to cache it
                .load(uri)
                .into(this)
    } else {
        Glide.with(context)
                .load(imageUrl)
                .fitCenter()
                .diskCacheStrategy( DiskCacheStrategy.SOURCE )
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(this)
    }

}

fun getGlideSvgRequestBuilder(context : Context) = Glide.with(context)
            .using(Glide.buildStreamModelLoader(Uri::class.java, context), InputStream::class.java)
            .from(Uri::class.java)
            .`as`(SVG::class.java)
            .transcode(SvgDrawableTranscoder(), PictureDrawable::class.java)
            .sourceEncoder(StreamEncoder())
            .cacheDecoder(FileToStreamDecoder(SvgDecoder()))
            .decoder(SvgDecoder())
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .animate(android.R.anim.fade_in)
            .listener(SvgSoftwareLayerSetter<Uri>())
