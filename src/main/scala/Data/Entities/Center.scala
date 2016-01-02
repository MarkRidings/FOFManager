package Data.Entities

import java.sql.ResultSet

case class Center(result: ResultSet) extends OffensiveLine(result) {

  def ComputeCurrentRating: Double = {
    (currentRunBlocking * 10 +
      currentPassBlocking * 5 +
      currentBlockingStrength * 0.5 +
      currentEndurance * 0.5) / 16.0
  }

  def ComputeFutureRating: Double = {
    (currentRunBlocking * 10 +
      currentPassBlocking * 5 +
      currentBlockingStrength * 0.5 +
      currentEndurance * 0.5) / 16.0
  }

}
