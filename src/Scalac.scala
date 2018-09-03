import model.{Game, GameSolver}

/**
  * Created by jAANUSZEK0700 on 01.09.2018.
  *
  * Main class initializes game parameters and solves it
  */
object Scalac extends App {
  val game = Game.init
  val result = GameSolver.solve(game)

  println(s"Number of results: ${result.length}")
  println(result.mkString("\n"))
}
