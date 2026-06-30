package com.example.afinal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.databinding.AmSnackItemBinding
import com.example.afinal.model.Snack

class SnackAdapter : ListAdapter<Snack, SnackAdapter.SnackViewHolder>(SnacksComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnackViewHolder {
        return SnackViewHolder.amCreate(parent)
    }

    override fun onBindViewHolder(holder: SnackViewHolder, position: Int) {
        val current = getItem(position)
        holder.amBind(current)
    }

    class SnackViewHolder(private val amBinding: AmSnackItemBinding) : RecyclerView.ViewHolder(amBinding.root) {
        fun amBind(snack: Snack) {
            amBinding.amTvSnackName.text = snack.amName
            amBinding.amTvSnackPrice.text = "$${snack.amPrice}"
            amBinding.amTvSnackDescription.text = snack.amDescription
        }

        companion object {
            fun amCreate(parent: ViewGroup): SnackViewHolder {
                val binding = AmSnackItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return SnackViewHolder(binding)
            }
        }
    }

    class SnacksComparator : DiffUtil.ItemCallback<Snack>() {
        override fun areItemsTheSame(oldItem: Snack, newItem: Snack): Boolean {
            return oldItem.amId == newItem.amId
        }

        override fun areContentsTheSame(oldItem: Snack, newItem: Snack): Boolean {
            return oldItem == newItem
        }
    }
}
