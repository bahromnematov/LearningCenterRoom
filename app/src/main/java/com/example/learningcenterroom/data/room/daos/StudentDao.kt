package uz.gita.learningcenterroom.data.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.gita.learningcenterroom.data.room.entities.GroupEntitiy
import uz.gita.learningcenterroom.data.room.entities.StudentEntitiy

@Dao
interface StudentDao {

    @Insert
    fun insert(studentEntitiy: StudentEntitiy)

    @Delete
    fun delate(groupEntitiy: GroupEntitiy)

    @Update
    fun update(groupEntitiy: GroupEntitiy)

    @Query("SELECT * FROM students WHERE groupId=:groupIds")
    fun getAllStudents(groupIds:Int):List<StudentEntitiy>
}