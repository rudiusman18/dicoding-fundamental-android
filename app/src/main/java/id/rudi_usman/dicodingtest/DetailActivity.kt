package id.rudi_usman.dicodingtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import id.rudi_usman.dicodingtest.databinding.ActivityDetailBinding
import id.rudi_usman.dicodingtest.viewmodels.listProgrammingLanguages
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    private var indexData by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        indexData = intent.getIntExtra("index",0)
        detailBinding.backIcon.setOnClickListener {
            finish()
        }

        Glide.with(this)
            .load(listProgrammingLanguages.listItems[indexData].imageURL)  // Load the image from the URL
            .placeholder(R.drawable.ic_launcher_background)  // Optional: Placeholder image
            .error(R.drawable.ic_launcher_foreground)  // Optional: Error image
            .into(detailBinding.imageview)  // Set the image in the ImageView
        detailBinding.titleTextview.text = listProgrammingLanguages.listItems[indexData].title
        detailBinding.descriptionTextview.text = listProgrammingLanguages.listItems[indexData].subtitle
    }
}