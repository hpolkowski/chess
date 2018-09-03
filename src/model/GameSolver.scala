package model

/**
  * Created by jAANUSZEK0700 on 03.09.2018.
  */

/**
  * Solves the game, contains all methods that are nerequired to solve a puzzle
  */
object GameSolver {

  /**
    * Solves the game, returns all found possibilities
    * @return list of solved games
    */
  def solve(game: Game): List[SolvedGame] = {
    val pieces = game.pieces.reverse

    (0 until game.board.n * game.board.m / 2).toList.map { i =>
      val solvedGame = SolvedGame.init(game)

      pieces.foreach { gamePiece =>
        insertInFirstFreeSpot(solvedGame, gamePiece)
      }
      solvedGame
    }
  }

  /**
    * Inserts given piece into first no threatening point
    * @param solvedGame object of current solved game
    * @param piece chess piece to insert
    */
  private def insertInFirstFreeSpot(solvedGame: SolvedGame, piece: GamePiece): Unit = {
    var success = false
    solvedGame.result.indices.foreach { n =>
      solvedGame.result(n).indices.foreach { m =>
        if(!success)
          success = solvedGame.insert(n, m, piece)
      }
    }
  }
}
