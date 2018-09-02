package model

/**
  * Created by jAANUSZEK0700 on 02.09.2018.
  */

/**
  * Game parameters
  * @param board  board dimensions
  * @param pieces list of chess pieces
  */
case class Game (
   board: Board,
   pieces: List[GamePiece]
 ) {

  /**
    * Solves the game, returns all found possibilities
    * @return list of solved games
    */
  def solve: List[SolvedGame] = {
    val solvedGame = SolvedGame.init(this)

    List(solvedGame)
  }
}

object Game {

  /**
    * Initializes game setting up the board and pieces
    * @return game object
    */
  def init: Game = {
    val board = Board.init
    val pieces = GamePieceType.values.toList.flatMap { pieceType =>
      GamePiece.init(pieceType)
    }

    Game(board, pieces)
  }
}
