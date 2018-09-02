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
)

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