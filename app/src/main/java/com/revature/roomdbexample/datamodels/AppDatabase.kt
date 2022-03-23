package com.revature.roomdbexample.datamodels

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.revature.roomdbexample.dao.CustomerData

@Database(entities = [Customer::class], version=1,exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun customerDao():CustomerData

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase?=null;

        fun getDatabase(context: Context):AppDatabase{
            val temInstance= INSTANCE
            if(temInstance!=null){
                return temInstance
            }
            synchronized(this){
                var instance=Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"Adama").build()
                INSTANCE=instance

                return instance
            }
        }
    }
}