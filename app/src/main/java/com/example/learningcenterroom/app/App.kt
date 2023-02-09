package uz.gita.learningcenterroom.app

import android.app.Application
import uz.gita.learningcenterroom.data.room.DBHelper.CourseDatabase

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        CourseDatabase.getDataBase(this)
    }

}