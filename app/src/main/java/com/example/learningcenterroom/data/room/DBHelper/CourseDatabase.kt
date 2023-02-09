package uz.gita.learningcenterroom.data.room.DBHelper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.learningcenterroom.data.room.daos.CourseDao
import uz.gita.learningcenterroom.data.room.daos.GroupDao
import uz.gita.learningcenterroom.data.room.daos.StudentDao
import uz.gita.learningcenterroom.data.room.entities.CourseEntitiy
import uz.gita.learningcenterroom.data.room.entities.GroupEntitiy
import uz.gita.learningcenterroom.data.room.entities.StudentEntitiy

@Database(
    entities = [CourseEntitiy::class, GroupEntitiy::class, StudentEntitiy::class], version = 1
)

abstract class CourseDatabase : RoomDatabase() {
    abstract fun getCourseDao(): CourseDao
    abstract fun getGroupDao(): GroupDao
    abstract fun getStudentDao(): StudentDao


    companion object {
        fun getInstance():CourseDatabase= database
        private lateinit var database: CourseDatabase
        fun getDataBase(context: Context): CourseDatabase {
            if (!this@Companion::database.isInitialized) {
                database = Room.databaseBuilder(context, CourseDatabase::class.java, "Courses.db")
                    .allowMainThreadQueries()
                    .build()

            }
            return database
        }


    }


}