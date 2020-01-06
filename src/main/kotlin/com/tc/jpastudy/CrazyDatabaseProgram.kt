package com.tc.jpastudy

import java.sql.Connection
import java.sql.ResultSet

data class Game(
    var id: Long,
    var name: String
)

class GameDao(private val con: Connection) {

    fun find(id: Long): Game {
        val sql = "SELECT id, name FROM game_info WHERE id = ?"

        val pstmt = con.prepareStatement(sql).also {
            it.setLong(1, id)
        }

        val result: ResultSet = pstmt.executeQuery()

        return Game(
            id = result.getLong(1),
            name = result.getString(2)
        )
    }

    fun insert(game: Game): Int {
        val sql = "INSERT INTO game_info(name) values(?)"

        val pstmt = con.prepareStatement(sql).also {
            it.setString(1, game.name)
        }

        return pstmt.executeUpdate()
    }
}
