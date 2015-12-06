package Displays

import java.sql.ResultSet

import Data.Entities.{RunningBack, Quarterback}

object PlayerDisplay {

  def BasicQB(qbs: Iterator[ResultSet]): Unit = {
    val header = "%25s\tcurrent rating\tfuture rating\tmentor\texp\tcurrent overall\tfuture overall".format("Name")
    val row = "%25s\t%14.3f\t%13.3f\t%6d\t%3d\t%15d\t%14d"
    println(header)
    val qbList = qbs.map(x => Quarterback(x)).toList
    qbList.sortBy(x => -x.ComputeCurrentRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentRating, r.ComputeFutureRating,
        r.mentor, r.exp, r.currentOverall, r.futureOverall))
    })
  }


  def BasicRB(rbs: Iterator[ResultSet]): Unit = {
    val header = "%25s\tcurrent run rating\tcurrent rec rating\tcurrent rating\tfuture rating" +
      "\tmentor\texp\tcurrent overall\tfuture overall"
    val row = "%25s\t%18.3f\t%18.3f\t%14.3f\t%13.3f\t%6d\t%3d\t%15d\t%14d"

    println(header.format("Name"))

    val rbList = rbs.map(x => RunningBack(x)).toList
    rbList.sortBy(x => -x.ComputeCurrentRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentRunRating, r.ComputeCurrentRecRating, r.ComputeCurrentRating,
        r.ComputeFutureRating, r.mentor, r.exp, r.currentOverall, r.futureOverall))
    })

  }
}
