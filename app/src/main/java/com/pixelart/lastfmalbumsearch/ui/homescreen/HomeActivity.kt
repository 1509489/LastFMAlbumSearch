package com.pixelart.lastfmalbumsearch.ui.homescreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pixelart.lastfmalbumsearch.R
import com.pixelart.lastfmalbumsearch.adapter.AlbumAdapter
import com.pixelart.lastfmalbumsearch.app.AlbumApp
import com.pixelart.lastfmalbumsearch.data.model.Album
import com.pixelart.lastfmalbumsearch.di.activity.ActivityModule
import com.pixelart.lastfmalbumsearch.ui.detailscreen.DetailActivity
import com.pixelart.lastfmalbumsearch.ui.detailscreen.DetailFragment

import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.item_list.*
import javax.inject.Inject

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [DetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class HomeActivity : AppCompatActivity(), AlbumAdapter.OnItemClickedListener {

    private var twoPane: Boolean = false
    private lateinit var albumAdapter: AlbumAdapter
    private lateinit var albumList: List<Album>

    @Inject lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        toolbar.title = title

        //Initialising dependency injection for the activity
        val activityComponent = (application as AlbumApp)
            .appComponent
            .newActivityComponent(ActivityModule(this))
        activityComponent.injectHomeActivity(this)

        albumAdapter = AlbumAdapter(this)

        rvAlbum.layoutManager = LinearLayoutManager(this)
        rvAlbum.adapter = albumAdapter

        if (album_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }
    }

    //Enter album name in the edit text and click search button to get list of albums
    fun onSearch(v: View){
        when(v.id){
            R.id.ibSearch ->{
                val albumQuery = etSearch.text.toString()
                homeViewModel.getAlbums(albumQuery).observe(this, Observer {
                    albumAdapter.submitList(it.album)
                    albumList = it.album
                })
            }
        }
    }
    //Interface method to allow click interaction for the recycler view adapter
    override fun onItemClicked(position: Int) {
        val album = albumList[position]

        if (twoPane){
            //Show the recycler view item detail side-by-side in the same screen on a large device
            val fragment = DetailFragment().apply{
                arguments = Bundle().apply {
                    putParcelable(DetailFragment.ARG_ALBUM, album)
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.album_detail_container, fragment)
                    .commit()
        }else{
            //Open a new screen to show the selected item detail on a small device
            startActivity(Intent(this, DetailActivity::class.java).also {
                it.putExtra(DetailFragment.ARG_ALBUM, album)
            })
        }
    }
}
