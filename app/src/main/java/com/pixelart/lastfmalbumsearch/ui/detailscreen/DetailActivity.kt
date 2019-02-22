package com.pixelart.lastfmalbumsearch.ui.detailscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pixelart.lastfmalbumsearch.R
import com.pixelart.lastfmalbumsearch.ui.homescreen.HomeActivity

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [HomeActivity].
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if(savedInstanceState == null){
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = DetailFragment().apply{
                arguments = Bundle().apply {
                    putParcelable(DetailFragment.ARG_ALBUM,
                            intent.getParcelableExtra(DetailFragment.ARG_ALBUM))
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.album_detail_container, fragment)
                    .commit()
        }
    }
}
