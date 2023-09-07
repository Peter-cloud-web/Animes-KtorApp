package com.example.heroesapp.di

import android.content.Context
import androidx.room.Room
import com.example.heroesapp.data.database.AnimeDatabase
import com.example.heroesapp.util.Constants.ANIMES_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AnimeDatabase::class.java,
            ANIMES_DATABASE
        ).build()

}