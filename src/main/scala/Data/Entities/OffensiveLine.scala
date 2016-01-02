package Data.Entities

import java.sql.ResultSet

abstract class OffensiveLine (result: ResultSet) {

  val name = result.getString("name")
  val team = result.getString("team")
  val mentor = result.getInt("mentor")
  val exp = result.getInt("experience")
  val position = result.getString("position")

  val currentRunBlocking = result.getInt("current_run_blocking")
  val currentPassBlocking = result.getInt("current_pass_blocking")
  val currentBlockingStrength = result.getInt("current_blocking_strength")
  val currentEndurance = result.getInt("current_endurance")
  val currentOverall = result.getInt("current_overall")

  val futureRunBlocking = result.getInt("future_run_blocking")
  val futurePassBlocking = result.getInt("future_pass_blocking")
  val futureBlockingStrength = result.getInt("future_blocking_strength")
  val futureEndurance = result.getInt("future_endurance")
  val futureOverall = result.getInt("future_overall")

  def ComputeCurrentRating: Double
  def ComputeFutureRating: Double
}
