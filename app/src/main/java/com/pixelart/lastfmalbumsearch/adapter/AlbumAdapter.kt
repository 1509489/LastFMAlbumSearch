package com.pixelart.lastfmalbumsearch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pixelart.lastfmalbumsearch.R
import com.pixelart.lastfmalbumsearch.common.GlideApp
import com.pixelart.lastfmalbumsearch.data.model.Album
import kotlinx.android.synthetic.main.albums_rv_layout.view.*

class AlbumAdapter(private val listener: OnItemClickedListener): ListAdapter<Album, AlbumAdapter.ViewHolder>(DIFF_CALLBACK){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.ViewHolder {
        context = parent.context
        val view:View = LayoutInflater.from(context).inflate(R.layout.albums_rv_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumAdapter.ViewHolder, position: Int) {
        val album = getItem(position)

        holder.apply {
            setupView(album)
            itemView.setOnClickListener { listener.onItemClicked(position) }
        }
    }


    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Album> = object : DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
                return oldItem == newItem
            }

        }
    }

    class ViewHolder(private val mView: View): RecyclerView.ViewHolder(mView){
        fun setupView(album: Album?){
            if (album !=null){
                mView.apply {
                    tvAlbumName.text = album.name
                    tvArtist.text = album.artist

                    GlideApp.with(context)
                            .load(album.image[1].text)
                            .placeholder(R.drawable.placeholder_albumart)
                            .error(R.drawable.placeholder_albumart)
                            .override(80, 80)
                            .into(ivAlbumImage)
                }
            }
        }
    }

    //Interface to listen for recycler view item click
    interface OnItemClickedListener{
        fun onItemClicked(position: Int)
    }
}