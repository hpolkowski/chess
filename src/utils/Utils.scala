package utils

/**
  * Created by jAANUSZEK0700 on 02.09.2018.
  */
object InputUtils {

  /**
    * Prints a prompt and then reads an Integer
    * @param prompt message
    * @return integer number
    */
  def readInt(prompt: String): Int = {
    printf(prompt)
    scala.io.StdIn.readInt()
  }
}

object ProfilingUtils {

  /**
    * Measures method execution time
    * @param block block of code to measure
    * @tparam R returning type
    * @return returns result of given code and writes execution time in console
    */
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block
    val t1 = System.nanoTime()
    val total = t1 - t0

    println(s"\nExecution time: ${total/1000000000D}s\n")
    result
  }
}
