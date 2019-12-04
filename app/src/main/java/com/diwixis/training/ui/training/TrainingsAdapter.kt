package com.diwixis.training.ui.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diwixis.training.R
import com.diwixis.training.Training
import kotlinx.android.synthetic.main.item_simple.view.*

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
class TrainingsAdapter(
    val items: MutableList<Training>,
    var onItemClick: ((Training) -> Unit)? = null
) :
    RecyclerView.Adapter<ViewHolder>() {

    fun add(newTraining: Training) {
        items.add(newTraining)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_simple,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAnimalType?.text = items[position].trainingType
        holder.container.setOnClickListener { onItemClick?.invoke(items[position]) }
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvAnimalType = view.title
    val container = view.root
}