package Data.Entities

import java.sql.ResultSet

/**
  * Created by MarkR on 12/11/2015.
  */
case class Tackle (result: ResultSet) extends OffensiveLine (result) {

  def ComputeCurrentRating: Double = {
    (currentRunBlocking * 5 +
      currentPassBlocking * 10 +
      currentBlockingStrength * 0.5 +
      currentEndurance * 0.5) / 16.0
  }

  def ComputeFutureRating: Double = {
    (currentRunBlocking * 5 +
      currentPassBlocking * 10 +
      currentBlockingStrength * 0.5 +
      currentEndurance * 0.5) / 16.0
  }

}
