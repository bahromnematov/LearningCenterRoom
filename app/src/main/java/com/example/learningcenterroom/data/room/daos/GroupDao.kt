package uz.gita.learningcenterroom.data.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.gita.learningcenterroom.data.room.entities.GroupEntitiy

@Dao
interface GroupDao {
    @Insert
    fun insert(groupEntitiy: GroupEntitiy)

    @Delete
    fun delate(groupEntitiy: GroupEntitiy)

    @Update
    fun update(groupEntitiy: GroupEntitiy)

    @Query("SELECT * FROM groups WHERE courseId=:courseIds")
    fun getAllGroups(courseIds:Int):List<GroupEntitiy>
}