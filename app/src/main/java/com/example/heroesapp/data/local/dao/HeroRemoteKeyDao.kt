package com.example.heroesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.heroesapp.domain.model.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

//    @Query("SELECT * FROM hero_remote_key_table WHERE id =:id")
//    suspend fun getRemoteKeyById(id:Int): HeroRemoteKey?
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAllRemoteKeys(heroRemoteKeys:List<HeroRemoteKey>)
//
//    @Query("DELETE * FROM hero_remote_key_table")
//    suspend fun deleteAllRemoteKeys()
}