package utils

import java.beans.Introspector

/**
  * Created by jAANUSZEK0700 on 02.09.2018.
  */
object InputUtils {

  /**
    * Prints a prompt and then reads an Integer
    * @param prompt message
    * @param min minimal input number
    * @param max maximum input number
    * @return integer number
    */
  def readInt(prompt: String, min: Int = Int.MinValue, max: Int = Int.MaxValue): Int = {
    printf(prompt)
    try {
      scala.io.StdIn.readInt() match {

        case input if input < min =>
          println(s"Number '$input' is to low, minimum is $min")
          readInt(prompt, min, max)

        case input if input > max =>
          println(s"Number '$input' is to high, maximum is $max")
          readInt(prompt, min, max)

        case input =>
          input
      }
    } catch { case e: Exception =>
      println(s"Error ${Introspector.decapitalize(e.getMessage)}")
      readInt(prompt, min, max)
    }
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
