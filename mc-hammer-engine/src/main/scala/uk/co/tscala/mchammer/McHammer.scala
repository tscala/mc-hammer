package uk.co.tscala.mchammer

import uk.co.tscala.mchammer.engine.McHammerEngine

import scala.util.Random

/**
  * Example application, using the MCH engine to estimate the value of Pi using a Monte Carlo technique.
  * 
  * @author tscala
  * @since 22/11/15.
  */
object McHammer {

  def main(args: Array[String]): Unit = {

    val trials = 1000
    val parallelism = 2

    val map = (seed: Long) => {
      val rand = new Random(seed)
      val x = rand.nextDouble()
      val y = rand.nextDouble()
      if (x * x + y * y < 1) 1 else 0
    }

    val reduce = (a: Int, b: Int) => a + b

    val pi = McHammerEngine.mapReduce(trials, parallelism, map, reduce)

    println("Pi is approximately: " + 4.0 * pi / trials)
  }
}
