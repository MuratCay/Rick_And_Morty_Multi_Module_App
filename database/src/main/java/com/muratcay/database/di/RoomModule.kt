package com.muratcay.database.di

import android.content.Context
import androidx.room.Room
import com.muratcay.database.dao.CharacterDao
import com.muratcay.database.db.CharactersDatabase
import com.muratcay.database.utils.CacheConstants
import com.muratcay.database.utils.CachePreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun rickAndMortyDatabase(@ApplicationContext context: Context): CharactersDatabase =
        Room.databaseBuilder(context, CharactersDatabase::class.java, CacheConstants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDao(db: CharactersDatabase): CharacterDao = db.cachedCharacterDao()

    @Provides
    @Singleton
    fun providePreferenceHelper(@ApplicationContext context: Context): CachePreferencesHelper {
        return CachePreferencesHelper(context)
    }
}*/
