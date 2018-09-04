package model

/**
  * Created by jAANUSZEK0700 on 02.09.2018.
  */
import GamePieceType._
import utils.InputUtils.readInt

/**
  * Chess piece object
  * @param pieceType  type of chess piece
  */
case class GamePiece (
  pieceType: GamePieceType
) {

  /**
    * Returns all movement options of certain game piece
    * @param row      row number
    * @param column   column number
    */
  def allMovementOptions(row: Int, column: Int, game: Game): List[(Int, Int)] = {
    pieceType match {

      case KING =>
        List((row - 1, column - 1), (row - 1, column), (row - 1, column + 1), (row, column - 1), (row, column + 1),
          (row + 1, column - 1), (row + 1, column), (row + 1, column + 1))

      case QUEEN =>
        //TODO: Finish this, use bishop and rook movement patterns
        List()

      case BISHOP =>
        //TODO: Finish this
        List()

      case ROOK =>
        ((0 to game.board.rows).toList.map { n =>
          (n, column)
        } ::: (0 to game.board.columns).toList.map { m =>
          (row, m)
        }).filterNot { case (n, m) =>
          (n == row) && (m == column)
        }

      case KNIGHT =>
        List((row - 2, column - 1), (row - 2, column + 1), (row - 1, column - 2), (row - 1, column + 2),
          (row + 1, column - 2), (row + 1, column + 2), (row + 2, column - 1), (row + 2, column + 1))

      case _ =>
        List()
    }
  }.filter { case (n, m) =>
    (n >= 0) && (n < game.board.rows) && (m >= 0) && (m < game.board.columns)
  }
}

object GamePiece {

  /**
    * Initializes number of game pieces of certain type
    * @param pieceType type of game piece
    * @return list of game pieces
    */
  def init(pieceType: GamePieceType): List[GamePiece] = {
    (1 to readInt(s"Enter number of ${pieceType.toString.toLowerCase}s: ")).map { i: Int =>
      GamePiece(pieceType)
    }.toList
  }
}