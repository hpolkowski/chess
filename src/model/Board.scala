package model

/**
  * Created by jAANUSZEK0700 on 02.09.2018.
  */
import utils.InputUtils.readInt

/**
  * Chess board
  * @param n number of rows
  * @param m number of columns
  */
case class Board (
  var n: Int,
  var m: Int
)

object Board {

  /**
    * Initializes game board dimensions
    */
  def init: Board = {
    val n = readInt("Enter number of board rows: ")
    val m = readInt("Enter number of board columns: ")
    Board(n, m)
  }
}
