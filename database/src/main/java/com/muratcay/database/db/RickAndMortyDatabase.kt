package com.muratcay.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muratcay.database.dao.CharacterDao
import com.muratcay.database.models.CharacterCacheEntity
import com.muratcay.database.models.CharacterLocationCacheEntity

@Database(
    entities = [CharacterCacheEntity::class, CharacterLocationCacheEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CharactersDatabase : RoomDatabase() {

    abstract fun cachedCharacterDao(): CharacterDao
}