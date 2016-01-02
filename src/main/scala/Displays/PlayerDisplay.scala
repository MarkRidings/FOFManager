package Displays

import java.sql.ResultSet

import Data.Entities._

object PlayerDisplay {

  def BasicQB(qbs: Iterator[ResultSet]): Unit = {
    val header = "%20s  current rating  future rating  mentor  exp  current overall  future overall".format("Name")
    val row = "%20s  %14.3f  %13.3f  %6d  %3d  %15d  %14d"
    println(header)
    val qbList = qbs.map(x => Quarterback(x)).toList
    qbList.sortBy(x => -x.ComputeCurrentRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentRating, r.ComputeFutureRating,
        r.mentor, r.exp, r.currentOverall, r.futureOverall))
    })
  }


  def BasicRB(rbs: Iterator[ResultSet]): Unit = {
    val header = "%20s  current run rating  current rec rating  current rating  future rating" +
      "  mentor  exp  current overall  future overall"
    val row = "%20s  %18.3f  %18.3f  %14.3f  %13.3f  %6d  %3d  %15d  %14d"

    println(header.format("Name"))

    val rbList = rbs.map(x => RunningBack(x)).toList
    rbList.sortBy(x => -x.ComputeCurrentRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentRunRating, r.ComputeCurrentRecRating, r.ComputeCurrentRating,
        r.ComputeFutureRating, r.mentor, r.exp, r.currentOverall, r.futureOverall))
    })
  }

  def BasicTE(tes: Iterator[ResultSet]): Unit = {
    val header = "%20s  current rating  future rating  mentor  exp  current overall  future overall".format("name")
    val row = "%20s  %14.3f  %13.3f  %6d  %3d  %15d  %14d"

    println(header)

    val teList = tes.map(x => TightEnd(x)).toList
    teList.sortBy(x => -x.ComputeCurrentRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentRating, r.ComputeFutureRating, r.mentor, r.exp, r.currentOverall, r.futureOverall))
    })
  }

  def BasicWR(wrs: Iterator[ResultSet]): Unit = {
    val header = "%20s  current rating  future rating  mentor  exp  current overall  future overall".format("name")
    val row = "%20s  %14.3f  %13.3f  %6d  %3d  %15d  %14d"

    println(header)

    val teList = wrs.map(x => WideReceiver(x)).toList
    teList.sortBy(x => -x.ComputeCurrentRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentRating, r.ComputeFutureRating, r.mentor, r.exp, r.currentOverall, r.futureOverall))
    })
  }

  def BasicOL(ol: Iterator[ResultSet]): Unit = {
    val header = "%20s  current rating  future rating  mentor  exp  position  current overall  future overall".format("name")
    val row = "%20s  %14.3f  %13.3f  %6d  %3d  %8s  %15d  %14d"

    println(header)

    val olList = ol.map(x => InitializeOLine(x)).toList
    olList.sortBy(x => -x.ComputeCurrentRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentRating, r.ComputeFutureRating, r.mentor, r.exp, r.position, r.currentOverall, r.futureOverall))
    })
  }

  def BasicDL(dl: Iterator[ResultSet]): Unit = {
    val header = "%20s  current outside rating  current inside rating  future outside rating  future inside rating  mentor  exp  position  current overall  future overall".format("name")
    val row = "%20s  %21.3f  %20.3f  %20.3f  %19.3f  %6d  %3d  %8s  %15d  %14d"

    println(header)

    val dlList = dl.map(x => DefensiveLine(x)).toList
    dlList.sortBy(x => if (x.position == "RDE" || x.position == "LDE") -x.ComputeCurrentOutsideRating else -x.ComputeCurrentInsideRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentOutsideRating, r.ComputeCurrentInsideRating, r.ComputeFutureOutsideRating, r.ComputeFutureInsideRating, r.mentor, r.exp, r.position, r.currentOverall, r.futureOverall))
    })
  }

  def BasicILB(ilbs: Iterator[ResultSet]): Unit = {
    val header = "%20s  current SILB rating  current WILB rating  future SILB rating  future WILB rating  mentor  exp  position  current overall  future overall".format("name")
    val row = "%20s  %19.3f  %19.3f  %18.3f  %18.3f  %6d  %3d  %8s  %15d  %14d"

    println(header)

    val ilbList = ilbs.map(x => Linebacker(x)).toList
    ilbList.sortBy(x => -x.ComputeCurrentSilbRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentSilbRating, r.ComputeCurrentWilbRating, r.ComputeFutureSilbRating, r.ComputeFutureWilbRating, r.mentor, r.exp, r.position, r.currentOverall, r.futureOverall))
    })
  }

  def BasicOLB(olbs: Iterator[ResultSet]): Unit = {
    val header = "%20s  current SLB rating  current WLB rating  future SLB rating  future WLB rating  mentor  exp  position  current overall  future overall".format("name")
    val row = "%20s  %18.3f  %18.3f  %17.3f  %17.3f  %6d  %3d  %8s  %15d  %14d"

    println(header)

    val olbList = olbs.map(x => Linebacker(x)).toList
    olbList.sortBy(x => -x.ComputeCurrentSlbRating).foreach(r => {
      println(row.format(r.name, r.ComputeCurrentSlbRating, r.ComputeCurrentWlbRating, r.ComputeFutureSlbRating, r.ComputeFutureWlbRating, r.mentor, r.exp, r.position, r.currentOverall, r.futureOverall))
    })
  }

  def InitializeOLine(x: ResultSet): OffensiveLine = {
    x.getString("position") match {
      case "C" => Center(x)
      case "LG" | "RG" => Guard(x)
      case "LT" | "RT" => Tackle(x)
    }
  }
}
