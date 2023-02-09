package com.example.learningcenterroom

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_student.*
import kotlinx.android.synthetic.main.dialog_add.view.btnOk
import kotlinx.android.synthetic.main.dialog_add.view.editName
import kotlinx.android.synthetic.main.dialog_custom.view.*
import uz.gita.learningcenterroom.adapter.StudentAdapter
import uz.gita.learningcenterroom.data.room.DBHelper.CourseDatabase
import uz.gita.learningcenterroom.data.room.entities.StudentEntitiy

class StudentActivity : AppCompatActivity() {
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_student)

        val get = intent.getIntExtra("id", 0)

        val studentDao = CourseDatabase.getInstance().getStudentDao()
        studentAdapter = StudentAdapter(studentDao.getAllStudents(get) as ArrayList<StudentEntitiy>)
        studentRV.adapter = studentAdapter
        addBtn.setOnClickListener {
            var alertDialog = Dialog(this)
            val view = LayoutInflater.from(this).inflate(R.layout.dialog_custom, null, false)
            alertDialog.setContentView(view)
            view.btnOk.setOnClickListener {
                if (view.editName.text.isNotEmpty()) {
                    val studentEntitiy = StudentEntitiy(
                        phone = view.editPhone.text.toString(),
                        groupId = get,
                        name = view.editName.text.toString()
                    )
                    studentDao.insert(studentEntitiy)
                    studentAdapter.submitItem(studentDao.getAllStudents(get) as ArrayList<StudentEntitiy>)
                } else {
                    Toast.makeText(this, "Telefon Numer Kiriting", Toast.LENGTH_SHORT).show()
                }
                alertDialog.dismiss()
            }
            alertDialog.show()
        }

    }


}