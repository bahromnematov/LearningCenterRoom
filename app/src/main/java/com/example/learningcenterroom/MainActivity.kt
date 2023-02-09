package com.example.learningcenterroom

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add.view.*
import com.example.learningcenterroom.adapter.CourseAdapter
import uz.gita.learningcenterroom.GroupActivity
import uz.gita.learningcenterroom.data.room.DBHelper.CourseDatabase
import uz.gita.learningcenterroom.data.room.entities.CourseEntitiy

class MainActivity : AppCompatActivity() {
    private lateinit var courseAdapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val courseDao = CourseDatabase.getInstance().getCourseDao()
        courseAdapter = CourseAdapter(courseDao.getAllCourse() as ArrayList<CourseEntitiy>, object : CourseAdapter.OnCourseClick {
                override fun onClick(course: CourseEntitiy) {
                    val intent = Intent(this@MainActivity, GroupActivity::class.java)
                    intent.putExtra("id", course.id)
                    startActivity(intent)
                }
            })
        courceRV.adapter = courseAdapter
        addBtn.setOnClickListener {
            var alertDialog = Dialog(this)
            var view = LayoutInflater.from(this).inflate(R.layout.dialog_add, null, false)
            alertDialog.setContentView(view)
            view.btnOk.setOnClickListener {
                if (view.editName.text.toString().isNotEmpty()) {
                    var courseEntitiy = CourseEntitiy(courseName = view.editName.text.toString())
                    courseDao.insert(courseEntitiy)
                    courseAdapter.submitItem(courseDao.getAllCourse() as ArrayList<CourseEntitiy>)
                } else {
                    Toast.makeText(this, "Cours nomi Kiriting", Toast.LENGTH_SHORT).show()
                }
                alertDialog.dismiss()
            }
            alertDialog.show()
        }
    }
}