package uz.gita.learningcenterroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningcenterroom.R
import kotlinx.android.synthetic.main.item_student.view.*
import uz.gita.learningcenterroom.data.room.entities.StudentEntitiy

class StudentAdapter(var list: ArrayList<StudentEntitiy>):RecyclerView.Adapter<StudentAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
        fun bind(studentEntitiy: StudentEntitiy){
            itemView.personName.text=studentEntitiy.name
            itemView.personPhoneNumber.text=studentEntitiy.phone

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }
    fun submitItem(listArrayList: ArrayList<StudentEntitiy>){
        list.clear()
        list.addAll(listArrayList)
        notifyDataSetChanged()

    }
}