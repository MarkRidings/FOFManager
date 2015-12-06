package Data.Entities

import java.sql.ResultSet

case class RunningBack (result: ResultSet) {
  
  val name = result.getString("name")
  val team = result.getString("team")
  val mentor = result.getInt("mentor")
  val exp = result.getInt("experience")
  
  val currentSpeed = result.getInt("current_speed")
  val currentPowerInside = result.getInt("current_power_inside")
  val currentThirdDownRuns = result.getInt("current_third_down_runs")
  val currentHoleRecognition = result.getInt("current_hole_recognition")
  val currentElusiveness = result.getInt("current_elusiveness")
  val currentSpeedOutside = result.getInt("current_speed_outside")
  val currentAvoidDrops = result.getInt("current_avoid_drops")
  val currentGetDownfield = result.getInt("current_get_downfield")
  val currentRouteRunning = result.getInt("current_route_running")
  val currentOverall = result.getInt("current_overall")

  val futureSpeed = result.getInt("future_speed")
  val futurePowerInside = result.getInt("future_power_inside")
  val futureThirdDownRuns = result.getInt("future_third_down_runs")
  val futureHoleRecognition = result.getInt("future_hole_recognition")
  val futureElusiveness = result.getInt("future_elusiveness")
  val futureSpeedOutside = result.getInt("future_speed_outside")
  val futureAvoidDrops = result.getInt("future_avoid_drops")
  val futureGetDownfield = result.getInt("future_get_downfield")
  val futureRouteRunning = result.getInt("future_route_running")
  val futureOverall = result.getInt("future_overall")
  
  def ComputeCurrentRunRating: Double = {
    (currentSpeed * 18 + 
      currentPowerInside * 3 + 
      currentThirdDownRuns * 0.5 + 
      currentHoleRecognition * 55 + 
      currentElusiveness * -5 + 
      currentSpeedOutside * 5) / 76.5
  }
  
  def ComputeCurrentRecRating: Double = {
    (currentAvoidDrops * 2 +
      currentGetDownfield * 35 + 
      currentRouteRunning * 15) / 52.0
  }
  
  def ComputeCurrentRating: Double = {
    ComputeCurrentRunRating * .75 + ComputeCurrentRecRating * .25
  }

  def ComputeFutureRunRating: Double = {
    (futureSpeed * 18 +
      futurePowerInside * 3 +
      futureThirdDownRuns * 0.5 +
      futureHoleRecognition * 55 +
      futureElusiveness * -5 +
      futureSpeedOutside * 5) / 76.5
  }

  def ComputeFutureRecRating: Double = {
    (futureAvoidDrops * 2 +
      futureGetDownfield * 35 +
      futureRouteRunning * 15) / 52.0
  }

  def ComputeFutureRating: Double = {
    ComputeFutureRunRating * .75 + ComputeFutureRecRating * .25
  }
}
