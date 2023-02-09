package uz.gita.learningcenterroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningcenterroom.R
import kotlinx.android.synthetic.main.item_view.view.*
import uz.gita.learningcenterroom.data.room.entities.GroupEntitiy

class GroupAdapter(var list: ArrayList<GroupEntitiy>, var onClick: OnGroupClick) :
    RecyclerView.Adapter<GroupAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(groupEntitiy: GroupEntitiy) {
            itemView.item_name.text = groupEntitiy.groupName

            itemView.setOnClickListener {
                onClick.onClick(groupEntitiy)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupAdapter.MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }


    override fun getItemCount(): Int = list.size

    fun submitItem(listArrayList: ArrayList<GroupEntitiy>) {
        list.clear()
        list.addAll(listArrayList)
        notifyDataSetChanged()

    }

    interface OnGroupClick {
        fun onClick(group: GroupEntitiy)
    }


    override fun onBindViewHolder(holder: GroupAdapter.MyViewHolder, position: Int) {
        holder.bind(list[position])
    }


}