/**
    Run FilterIsis as a jar on spark-submit
 */




package com.uncharted

import scala.io.Source
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object FilterForAccounts {
  def main(args: Array[String]) {
    val sc = new SparkContext(new SparkConf().setAppName("Spark Filter ISIS"))
    val accountFile = args(0)
    val inpath = args(1)
    val outpath = args(2)
    val files = sc.textFile(inpath)

    val accounts = Source.fromFile(accountFile).getLines.toArray
    val pattern = ("(\\b|@)(" + accounts.mkString("|") + ")\\b").r

    val account_filter = files.filter(x => pattern.findAllIn(x).length > 0 ).cache
    account_filter.saveAsTextFile(outpath)
  }
}


