package com.example.androidapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidapp.data.db.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): Dao
}