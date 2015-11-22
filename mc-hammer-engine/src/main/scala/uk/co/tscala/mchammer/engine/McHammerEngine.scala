package uk.co.tscala.mchammer.engine

import org.apache.spark.{SparkContext, SparkConf}

import scala.reflect.ClassTag
import scala.util.Random

/**
  * Monte Carlo execution engine - based on Apache Spark.
  *
  * @author tscala
  * @since 21/11/15.
  */
object McHammerEngine {

  val conf = new SparkConf().setMaster("local[2]").setAppName("McHammerEngine")
  val context = new SparkContext(conf)

  def mapReduce[T:ClassTag](numTrials: Int, parallelism: Int, map: Long => T ,reduce: (T, T) => T): T = {
    val seed = System.currentTimeMillis()

    val seeds = seed until seed + numTrials

    println(seeds)

    val seedRdd = context.parallelize(seeds, seeds.length)

    seedRdd.map(map).reduce(reduce)
  }
}

