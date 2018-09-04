package model

/**
  * Created by jAANUSZEK0700 on 02.09.2018.
  */
import utils.InputUtils.readInt

/**
  * Chess board
  * @param rows     number of rows
  * @param columns  number of columns
  */
case class Board (
   var rows: Int,
   var columns: Int
)

object Board {

  /**
    * Initializes game board dimensions
    */
  def init: Board = {
    val rows = readInt("Enter number of board rows: ")
    val columns = readInt("Enter number of board columns: ")
    Board(rows, columns)
  }
}
