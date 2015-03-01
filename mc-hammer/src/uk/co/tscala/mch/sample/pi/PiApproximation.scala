package uk.co.tscala.mch.sample.pi

import scala.math.random
import org.apache.spark._

object PiApproximation  {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName("Spark Pi")
    val spark = new SparkContext(conf)
    val slices = 2
    val n = math.min(100000000L * slices, Int.MaxValue).toInt // avoid overflow
    val count = spark.parallelize(1 until n, slices).map { i =>
      val x = random * 2 - 1
      val y = random * 2 - 1
      if (x * x + y * y < 1) 1 else 0
    }.reduce(_ + _)
    println("Pi is roughly " + 4.0 * count / n)
    spark.stop()
  }
}