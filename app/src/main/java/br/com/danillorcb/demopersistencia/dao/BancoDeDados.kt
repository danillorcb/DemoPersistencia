package br.com.danillorcb.demopersistencia.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.danillorcb.demopersistencia.model.Game
import java.security.AccessControlContext

@Database(entities = arrayOf(Game::class), version = 1)
abstract class BancoDeDados: RoomDatabase() {

    abstract fun gameDAO(): GameDAO

    companion object {
        var INSTANCE: BancoDeDados? = null

        fun getDatabase(context: Context): BancoDeDados? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                        BancoDeDados::class.java,
                        "gamesdb").build()
            }

            return INSTANCE
        }
    }
}