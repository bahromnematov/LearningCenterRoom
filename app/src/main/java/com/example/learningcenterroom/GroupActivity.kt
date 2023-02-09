package uz.gita.learningcenterroom

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.learningcenterroom.R
import com.example.learningcenterroom.StudentActivity
import kotlinx.android.synthetic.main.activity_group.*
import kotlinx.android.synthetic.main.activity_main.addBtn
import kotlinx.android.synthetic.main.dialog_add.view.*
import uz.gita.learningcenterroom.adapter.GroupAdapter
import uz.gita.learningcenterroom.data.room.DBHelper.CourseDatabase
import uz.gita.learningcenterroom.data.room.entities.GroupEntitiy

class GroupActivity : AppCompatActivity() {
    private lateinit var groupAdapter: GroupAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        val get = intent.getIntExtra("id", 0)

        val groupDao = CourseDatabase.getInstance().getGroupDao()
        groupAdapter = GroupAdapter(groupDao.getAllGroups(get) as ArrayList<GroupEntitiy>, object : GroupAdapter.OnGroupClick {
                override fun onClick(group: GroupEntitiy) {
                    val intent = Intent(this@GroupActivity, StudentActivity::class.java)
                    intent.putExtra("id", group.id)
                    startActivity(intent)
                }
            })
        groupRV.adapter = groupAdapter
        addBtn.setOnClickListener {
            var alertDialog = Dialog(this)
            var view = LayoutInflater.from(this).inflate(R.layout.dialog_add, null, false)
            alertDialog.setContentView(view)
            view.btnOk.setOnClickListener {
                if (view.editName.text.toString().isNotEmpty()) {
                    var groupEntitiy =
                        GroupEntitiy(groupName = view.editName.text.toString(), courseId = get)
                    groupDao.insert(groupEntitiy)
                    groupAdapter.submitItem(groupDao.getAllGroups(get) as ArrayList<GroupEntitiy>)
                } else {
                    Toast.makeText(this, "Cours nomi Kiriting", Toast.LENGTH_SHORT).show()
                }
                alertDialog.dismiss()
            }
            alertDialog.show()
        }
    }


}