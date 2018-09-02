package model

/**
  * Created by jAANUSZEK0700 on 02.09.2018.
  */

/**
  * Contains solved game representation
  * @param result representation of solved chess board
  */
case class SolvedGame (
  result: List[List[String]]
) {

  /**
    * Number of board columns
    */
  private val resultColumnCount: Int = result.headOption.map(_.length).getOrElse(0)

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
    (0 until game.board.n).toList.map { n =>
      (0 until game.board.m).toList.map { m =>
        " "
      }
    }
  )
}
