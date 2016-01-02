package Data.Entities

import java.sql.ResultSet

case class DefensiveLine (result: ResultSet) {

  val name = result.getString("name")
  val team = result.getString("team")
  val mentor = result.getInt("mentor")
  val exp = result.getInt("experience")
  val position = result.getString("position")
  
  val currentPassRush = result.getInt("current_pass_rush_technique")
  val currentPassRushStrength = result.getInt("current_pass_rush_strength")
  val currentRunDefense = result.getInt("current_run_defense")
  val currentPlayDiagnosis = result.getInt("current_play_diagnosis")
  val currentPunishingHitter = result.getInt("current_punishing_hitter")

  val futurePassRush = result.getInt("future_pass_rush_technique")
  val futurePassRushStrength = result.getInt("future_pass_rush_strength")
  val futureRunDefense = result.getInt("future_run_defense")
  val futurePlayDiagnosis = result.getInt("future_play_diagnosis")
  val futurePunishingHitter = result.getInt("future_punishing_hitter")

  val currentOverall = result.getInt("current_overall")
  val futureOverall = result.getInt("future_overall")

  def ComputeCurrentOutsideRating: Double = {
    (currentPassRush * 5 +
      currentPassRushStrength * 3 +
      currentRunDefense * 1.5 +
      currentPlayDiagnosis + 
      currentPunishingHitter) / 11.5
  }
  
  def ComputeCurrentInsideRating: Double = {
    (currentPassRush * 2 +
      currentPassRushStrength * 3 +
      currentRunDefense * 5 +
      currentPlayDiagnosis + 
      currentPunishingHitter) / 12.0
  }
  
  def ComputeFutureOutsideRating: Double = {
    (futurePassRush * 5 +
      futurePassRushStrength * 3 +
      futureRunDefense * 1.5 +
      futurePlayDiagnosis +
      futurePunishingHitter) / 11.5
  }
  
  def ComputeFutureInsideRating: Double = {
    (futurePassRush * 2 +
      futurePassRushStrength * 3 +
      futureRunDefense * 5 +
      futurePlayDiagnosis +
      futurePunishingHitter) / 12.0
  }
}
