package uk.co.tscala.mch.spark

import org.apache.spark._
import org.apache.spark.SparkContext._

class DefaultSparkEngine extends SparkEngine {
  
  def submit[T](sparkTask: SparkTask) = {
    // something?
    val conf = new SparkConf().setAppName(sparkTask.getName())
    val spark =  = new SparkContext(conf)
    val slices = sparkTask.getSlices()
    spark.parallelize().map
  }
}
