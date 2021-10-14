package com.firewave.rustmanager.server

import androidx.room.PrimaryKey

data class Server(
    @PrimaryKey(autoGenerate = true) val id:Int = 0
) {

    companion object {
        var currentServer:Server? = null
    }
}