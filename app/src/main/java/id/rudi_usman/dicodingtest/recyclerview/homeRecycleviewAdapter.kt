package id.rudi_usman.dicodingtest.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.rudi_usman.dicodingtest.MainActivity
import id.rudi_usman.dicodingtest.R
import id.rudi_usman.dicodingtest.databinding.RecycleviewItemBinding

class ItemAdapter(private val itemList: List<item>,
                  private val mainActivity: MainActivity
)  :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: RecycleviewItemBinding) : RecyclerView.ViewHolder(binding.root){
        init{
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mainActivity.onItemClicked(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val dataBinding = RecycleviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        // Use holder.binding to access your views
        holder.binding.itemTitle.text = item.title  // Assuming 'title' is a property of 'Item'
        holder.binding.itemSubtitle.text = item.subtitle  // Assuming 'subtitle' is another property
        Glide.with(holder.binding.contentImageview.context)
            .load(item.imageURL)  // Load the image from the URL
            .placeholder(R.drawable.ic_launcher_background)  // Optional: Placeholder image
            .error(R.drawable.ic_launcher_foreground)  // Optional: Error image
            .into(holder.binding.contentImageview)  // Set the image in the ImageView
    }

    override fun getItemCount(): Int = itemList.size
}
