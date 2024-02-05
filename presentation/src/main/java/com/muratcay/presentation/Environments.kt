package com.muratcay.presentation

object Environments {
    object Release {
        const val appId = "com.muratcay.rick_and_morty_multi_module_app"
        const val appVersionCode = 1
        const val appVersionName = "1.0"
        const val baseUrl = "https://rickandmortyapi.com/api/"
    }
}

// Object içinde object kullanmamın sebebi, Environments objesinin içinde Release ve Debug objelerini tutmak istememdir.