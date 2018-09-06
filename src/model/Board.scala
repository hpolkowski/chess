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
    val rows = readInt("Enter number of board rows: ", min = 0, max = 999)
    val columns = readInt("Enter number of board columns: ", min = 0, max = 18278)
    Board(rows, columns)
  }
}
