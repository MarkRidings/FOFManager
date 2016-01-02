package Data.Entities

import java.sql.ResultSet

case class TightEnd (result: ResultSet) {

  val name = result.getString("name")
  val team = result.getString("team")
  val mentor = result.getInt("mentor")
  val exp = result.getInt("experience")

  val currentAvoidDrops = result.getInt("current_avoid_drops")
  val currentGetDownfield = result.getInt("current_get_downfield")
  val currentRouteRunning = result.getInt("current_route_running")
  val currentThirdDownReceiving = result.getInt("current_third_down_receiving")
  val currentBigPlayReceiving = result.getInt("current_big_play_receiving")
  val currentCourage = result.getInt("current_courage")
  val currentAdjustToBall = result.getInt("current_adjust_to_ball")
  val currentRunBlocking = result.getInt("current_run_blocking")
  val currentPassBlocking = result.getInt("current_pass_blocking")
  val currentBlockingStrength = result.getInt("current_blocking_strength")
  val currentOverall = result.getInt("current_overall")

  val futureAvoidDrops = result.getInt("future_avoid_drops")
  val futureGetDownfield = result.getInt("future_get_downfield")
  val futureRouteRunning = result.getInt("future_route_running")
  val futureThirdDownReceiving = result.getInt("future_third_down_receiving")
  val futureBigPlayReceiving = result.getInt("future_big_play_receiving")
  val futureCourage = result.getInt("future_courage")
  val futureAdjustToBall = result.getInt("future_adjust_to_ball")
  val futureRunBlocking = result.getInt("future_run_blocking")
  val futurePassBlocking = result.getInt("future_pass_blocking")
  val futureBlockingStrength = result.getInt("future_blocking_strength")
  val futureOverall = result.getInt("future_overall")
  
  def ComputeCurrentRating: Double = {
    (currentAvoidDrops * 2 +
      currentGetDownfield * 25 +
      currentRouteRunning * 10 +
      currentThirdDownReceiving * 0.5 +
      currentBigPlayReceiving * 15 + 
      currentCourage * 8 +
      currentAdjustToBall * 3 +
      currentRunBlocking * 1.5 +
      currentPassBlocking * 0.5 + 
      currentBlockingStrength * 0.5) / 66.0
  }
  
  def ComputeFutureRating: Double = {
    (futureAvoidDrops * 2 +
      futureGetDownfield * 25 +
      futureRouteRunning * 10 +
      futureThirdDownReceiving * 0.5 +
      futureBigPlayReceiving * 15 +
      futureCourage * 8 +
      futureAdjustToBall * 3 +
      futureRunBlocking * 1.5 +
      futurePassBlocking * 0.5 +
      futureBlockingStrength * 0.5) / 66.0
  }
}
