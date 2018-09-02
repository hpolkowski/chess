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
