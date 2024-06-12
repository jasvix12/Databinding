package com.adso.databinding.Data

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.adso.databinding.Usuario


@Database(entities = [Usuario::class], version = 1)

abstract class UserDataBase: RoomDatabase() {
    abstract val userDao: UserDao


    companion object {
        @Volatile
        private var INSTANCE: UserDataBase ?= null
        fun getInstance(context: Context): UserDataBase {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDataBase::class.java,
                        "user_db"
                    )
                        .build()
                }
                INSTANCE = instance
                return instance
            }

        }
    }
}