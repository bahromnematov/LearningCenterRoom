package uz.gita.learningcenterroom.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "students", indices = [Index(value = ["phone"], unique = true)])
data class StudentEntitiy(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val name:String,
    val phone:String,
    val groupId:Int
)