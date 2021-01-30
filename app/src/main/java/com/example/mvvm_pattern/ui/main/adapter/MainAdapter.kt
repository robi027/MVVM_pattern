package com.example.mvvm_pattern.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_pattern.R
import com.example.mvvm_pattern.data.model.Meal
import kotlinx.android.synthetic.main.item_meals.view.*

class MainAdapter(private val meals: ArrayList<Meal>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_meals, parent, false)
        )

    override fun getItemCount(): Int = meals.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(meal: Meal) {
            itemView.apply {
                tvTitle.text = meal.strMeal
            }
        }
    }

    fun addMeals(meals: List<Meal>) {
        this.meals.apply {
            clear()
            addAll(meals)
        }
    }
}