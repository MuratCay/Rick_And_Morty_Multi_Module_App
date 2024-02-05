package com.muratcay.database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.muratcay.database.utils.CacheConstants
import org.intellij.lang.annotations.Identifier

@Entity(tableName = CacheConstants.CHARACTER_LOCATION_TABLE_NAME)
data class CharacterLocationCacheEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "location_id")
    val id: Int = 0,
    @ColumnInfo(name = "location")
    val name: String,
    @ColumnInfo(name = "location_url")
    val url: String
)
