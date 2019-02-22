package com.pixelart.lastfmalbumsearch.ui.detailscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixelart.lastfmalbumsearch.R
import com.pixelart.lastfmalbumsearch.common.GlideApp
import com.pixelart.lastfmalbumsearch.data.model.Album
import com.pixelart.lastfmalbumsearch.ui.homescreen.HomeActivity
import kotlinx.android.synthetic.main.fragment_detail.view.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [HomeActivity]
 * in two-pane mode (on tablets) or a [DetailActivity]
 * on handsets.
 */
class DetailFragment : Fragment() {
    private var album: Album? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            if(it.containsKey(ARG_ALBUM)){
                //get the album based on the fragement arguments
                album = it.getParcelable(ARG_ALBUM)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)

        //Setup the view elements for the fragment
        rootView.apply {
            tvAlbumName.text = album?.name
            tvArtist.text = album?.artist

            GlideApp.with(context)
                    .load(album!!.image[2].text)
                    .placeholder(R.drawable.placeholder_albumart)
                    .error(R.drawable.placeholder_albumart)
                    .into(ivAlbumArt)
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the album that this fragment.
         */
        const val ARG_ALBUM = "album_args"
    }
}
