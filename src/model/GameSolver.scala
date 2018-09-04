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

    (0 until (game.board.rows * game.board.columns / 2D).round.toInt).toList.flatMap { i =>
      val solvedGame = SolvedGame.init(game)

      val success = pieces.forall { gamePiece =>
        insertInFirstFreeSpot(i, solvedGame, gamePiece)
      }

      if(success) Some(solvedGame) else None
    }
    //TODO: Add board rotation function, because every solution can be shown in four options
  }

  /**
    * Inserts given piece into first no threatening point
    * @param solvedGame object of current solved game
    * @param piece chess piece to insert
    * @return true if successfully inserted
    */
  private def insertInFirstFreeSpot(offset: Int, solvedGame: SolvedGame, piece: GamePiece): Boolean = {
    var success = false
    val rowOffset = offset / solvedGame.game.board.columns
    var columnOffset = offset % solvedGame.game.board.columns

    (rowOffset until solvedGame.game.board.rows).foreach { n =>
      (columnOffset until solvedGame.game.board.columns).foreach { m =>
        columnOffset = 0
        if(!success)
          success = solvedGame.insert(n, m, piece)
      }
    }

    success
  }
}
