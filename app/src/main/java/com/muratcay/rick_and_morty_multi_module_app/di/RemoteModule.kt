package com.muratcay.rick_and_morty_multi_module_app.di

import com.muratcay.data.repository.CharacterRemote
import com.muratcay.remote.repository.CharacterRemoteImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideCharacterRemote(characterRemote: CharacterRemoteImp): CharacterRemote {
        return characterRemote
    }
}