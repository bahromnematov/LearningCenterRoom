package uz.gita.learningcenterroom.data.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.gita.learningcenterroom.data.room.entities.CourseEntitiy

@Dao
interface CourseDao {
    @Insert
    fun insert(courseEntitiy: CourseEntitiy)

    @Delete
    fun delete(courseEntitiy: CourseEntitiy)

    @Update
    fun update(courseEntitiy: CourseEntitiy)

    @Query("SELECT * FROM course")
    fun getAllCourse(): List<CourseEntitiy>

}