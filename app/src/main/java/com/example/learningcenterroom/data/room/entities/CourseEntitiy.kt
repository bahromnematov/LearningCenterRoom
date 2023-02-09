package uz.gita.learningcenterroom.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "course", indices = [Index(value = ["course_name"], unique = true)])

data class CourseEntitiy(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    @ColumnInfo(name = "course_name")
    val courseName: String

)


