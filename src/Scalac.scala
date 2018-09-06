import model.{Game, GameSolver}
import utils.ProfilingUtils._

/**
  * Created by jAANUSZEK0700 on 01.09.2018.
  *
  * Main class initializes game parameters and solves it
  */
object Scalac extends App {
  val game = Game.init
  val result = time(GameSolver.solve(game))

  println(s"Number of results: ${result.length}")
  println(result.mkString("\n"))
}
