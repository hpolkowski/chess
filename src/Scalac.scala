import model.{Game, SolvedGame}

/**
  * Created by jAANUSZEK0700 on 01.09.2018.
  *
  * Main class initializes game parameters and solves it
  */
object Scalac extends App {
  val game = Game.init

  println(game.solve.mkString("\n"))
}
