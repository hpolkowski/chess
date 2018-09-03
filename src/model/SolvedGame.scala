package model

/**
  * Created by jAANUSZEK0700 on 02.09.2018.
  */

/**
  * Contains solved game representation
  * @param result representation of solved chess board
  */
import GamePieceType._

case class SolvedGame (
  var result: Array[Array[String]]
) {

  /**
    * Number of board columns
    */
  private val resultColumnCount: Int = result.headOption.map(_.length).getOrElse(0)

  /**
    * Inserts given type of chess piece into selected place on board
    * @param n      row number
    * @param m      column number
    * @param piece  chess piece
    * @param preserveMovement if true places a dot in every spot that piece can move
    * @return true if success otherwise false
    */
  def insert(n: Int, m: Int, piece: GamePiece, preserveMovement: Boolean = true): Boolean =
  //TODO: Check if ne piece do not interfere with old pieces, can use method from TODO below
    if(result(n)(m) == " ") {
      result(n)(m) = piece.pieceType match {
        case KING => "K"
        case QUEEN => "Q"
        case BISHOP => "B"
        case ROOK => "R"
        case KNIGHT => "N"
        case _ => " "
      }

      if(preserveMovement)
        preservePieceMovement(n, m, piece)

      true
    } else
      false

  /**
    * Sets dots in every place on boart that piece can move to preserve form being taken by other piece
    * @param n      row number
    * @param m      column number
    * @param piece  chess piece
    */
  private def preservePieceMovement(n: Int, m: Int, piece: GamePiece): Unit = {
    //TODO: Replace this code into GamePiece, return array with all coordinates to fill
    piece.pieceType match {

      case KING =>
        setDotIfPossible(n - 1, m - 1)
        setDotIfPossible(n - 1, m)
        setDotIfPossible(n - 1, m + 1)
        setDotIfPossible(n, m - 1)
        setDotIfPossible(n, m + 1)
        setDotIfPossible(n + 1, m - 1)
        setDotIfPossible(n + 1, m)
        setDotIfPossible(n + 1, m + 1)

      case QUEEN =>

      case BISHOP =>

      case ROOK =>

      case KNIGHT =>
        setDotIfPossible(n - 2, m - 1)
        setDotIfPossible(n - 2, m + 1)
        setDotIfPossible(n - 1, m - 2)
        setDotIfPossible(n - 1, m + 2)
        setDotIfPossible(n + 1, m - 2)
        setDotIfPossible(n + 1, m + 2)
        setDotIfPossible(n + 2, m - 1)
        setDotIfPossible(n + 2, m + 1)

      case _ =>
    }
  }

  /**
    * Sets dot in solved game array if possible
    * @param n row number
    * @param m column number
    */
  private def setDotIfPossible(n: Int, m: Int): Unit = {
    if(n >= 0 && m >= 0 && n < result.length && m < result(n).length && result(n)(m) == " ")
      result(n)(m) = "."
  }

  /**
    * Prints out solved game
    * @return string with solved game visual representation
    */
  override def toString: String = boardColumnDescription +
    result.zipWithIndex.map { case (resultRow, i) =>
      resultRow.mkString(String.format("%5s", i + 1 + "| "), " | ", " |\n")
    }.mkString(boardSeparator, boardSeparator, boardSeparator)

  /**
    * Adds column description to board visual representation
    * @return string with column descriptors
    */
  private def boardColumnDescription: String = (1 to resultColumnCount).map { i =>
    String.format("%3s", intToBase26String(i))
  }.mkString("   |", "|", "|\n").replaceAll("`", " ")

  /**
    * Transforms an integer to string counting eg. a, b...z, aa, ab...zzz.
    * @param int integer number to transform
    * @return string counting
    */
  private def intToBase26String(int: Int): String = {
    var number = int
    var result = ""
    val offset = 97
    val noOfChars = 26

    while (number > 0) {
      number = number - 1
      result = (number % noOfChars + offset).asInstanceOf[Char] + result
      number = (number - (number % noOfChars)) / noOfChars
    }
    result
  }

  /**
    * Adds separation line to board
    * @return string with separation line
    */
  private def boardSeparator: String = s"---${"+---" * resultColumnCount}+\n"
}

object SolvedGame {

  /**
    * Initializes solved game with empty cells
    *
    * @param game game to solve object
    * @return empty object of SolvedGame
    */
  def init(game: Game): SolvedGame = SolvedGame (
    (0 until game.board.n).toArray.map { n =>
      (0 until game.board.m).toArray.map { m =>
        " "
      }
    }
  )
}
