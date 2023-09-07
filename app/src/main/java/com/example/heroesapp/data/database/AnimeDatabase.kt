package com.example.heroesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.heroesapp.data.DatabaseConverter
import com.example.heroesapp.data.local.dao.HeroDao
import com.example.heroesapp.data.local.dao.HeroRemoteKeyDao
import com.example.heroesapp.domain.model.Hero
import com.example.heroesapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class,HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class AnimeDatabase: RoomDatabase(){

    abstract fun heroDao():HeroDao
    abstract fun heroRemoteKeyDao():HeroRemoteKeyDao
}