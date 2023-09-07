package com.example.heroesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.heroesapp.data.local.dao.HeroDao
import com.example.heroesapp.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class AnimeDatabase: RoomDatabase(){

    abstract fun heroDao():HeroDao
}