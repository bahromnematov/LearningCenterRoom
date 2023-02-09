package com.example.learningcenterroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningcenterroom.R
import kotlinx.android.synthetic.main.item_view.view.*
import uz.gita.learningcenterroom.data.room.entities.CourseEntitiy

class CourseAdapter(var list: ArrayList<CourseEntitiy> ,var onClick : OnCourseClick) : RecyclerView.Adapter<CourseAdapter.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(courseEntitiy: CourseEntitiy) {
            itemView.item_name.text = courseEntitiy.courseName

            itemView.setOnClickListener {
                onClick.onClick(courseEntitiy)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun submitItem(listArrayList: ArrayList<CourseEntitiy>){
        list.clear()
        list.addAll(listArrayList)
        notifyDataSetChanged()

    }

    interface OnCourseClick{
        fun onClick(course: CourseEntitiy)
    }



}
