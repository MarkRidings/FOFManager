package Data.Entities

import java.sql.ResultSet

case class Linebacker (result: ResultSet) {

  val name = result.getString("name")
  val team = result.getString("team")
  val mentor = result.getInt("mentor")
  val exp = result.getInt("experience")
  val position = result.getString("position")

  val currentPassRush = result.getInt("current_pass_rush_technique")
  val currentPassRushStrength = result.getInt("current_pass_rush_strength")
  val currentRunDefense = result.getInt("current_run_defense")
  val currentZoneDefense = result.getInt("current_zone_defense")
  val currentManToManDefense = result.getInt("current_man_to_man_defense")
  val currentBumpAndRunDefense = result.getInt("current_bump_and_run_defense")
  val currentPlayDiagnosis = result.getInt("current_play_diagnosis")
  val currentPunishingHitter = result.getInt("current_punishing_hitter")

  val futurePassRush = result.getInt("future_pass_rush_technique")
  val futurePassRushStrength = result.getInt("future_pass_rush_strength")
  val futureRunDefense = result.getInt("future_run_defense")
  val futureZoneDefense = result.getInt("future_zone_defense")
  val futureManToManDefense = result.getInt("future_man_to_man_defense")
  val futureBumpAndRunDefense = result.getInt("future_bump_and_run_defense")
  val futurePlayDiagnosis = result.getInt("future_play_diagnosis")
  val futurePunishingHitter = result.getInt("future_punishing_hitter")
  
  val currentOverall = result.getInt("current_overall")
  val futureOverall = result.getInt("future_overall")
  
  def ComputeCurrentSilbRating: Double = {
    (currentPassRush * 2 +
      currentPassRushStrength * 2 +
      currentRunDefense * 4 + 
      currentZoneDefense * 5 +
      currentManToManDefense * 1.5 +
      currentBumpAndRunDefense +
      currentPlayDiagnosis * 2 +
      currentPunishingHitter) / 18.5
  }

  def ComputeCurrentWilbRating: Double = {
    (currentPassRush * 2 +
    currentPassRushStrength * 2 +
    currentRunDefense * 5 +
    currentZoneDefense  +
    currentManToManDefense +
    currentBumpAndRunDefense +
    currentPlayDiagnosis * 2 +
    currentPunishingHitter) / 15.0
  }

  def ComputeCurrentSlbRating: Double = {
    (currentPassRush * 2 +
      currentPassRushStrength * 2 +
      currentRunDefense * 2 +
      currentZoneDefense * 4 +
      currentManToManDefense * 6 +
      currentBumpAndRunDefense * 2 +
      currentPlayDiagnosis * 2 +
      currentPunishingHitter) / 21.0
  }

  def ComputeCurrentWlbRating: Double = {
    (currentPassRush * 10 +
      currentPassRushStrength * 6 +
      currentRunDefense * 4 +
      currentZoneDefense * 0.5 +
      currentManToManDefense * 0.5 +
      currentBumpAndRunDefense * 0.5 +
      currentPlayDiagnosis * 2 +
      currentPunishingHitter) / 24.5
  }
  
  def ComputeFutureSilbRating: Double = {
    (futurePassRush * 2 +
      futurePassRushStrength * 2 +
      futureRunDefense * 4 +
      futureZoneDefense * 5 +
      futureManToManDefense * 1.5 +
      futureBumpAndRunDefense +
      futurePlayDiagnosis * 2 +
      futurePunishingHitter) / 18.5
  }
  
  def ComputeFutureWilbRating: Double = {
    (futurePassRush * 2 +
      futurePassRushStrength * 2 +
      futureRunDefense * 5 +
      futureZoneDefense  +
      futureManToManDefense +
      futureBumpAndRunDefense +
      futurePlayDiagnosis * 2 +
      futurePunishingHitter) / 15.0
  }
  
  def ComputeFutureSlbRating: Double = {
    (futurePassRush * 2 +
      futurePassRushStrength * 2 +
      futureRunDefense * 2 +
      futureZoneDefense * 4 +
      futureManToManDefense * 6 +
      futureBumpAndRunDefense * 2 +
      futurePlayDiagnosis * 2 +
      futurePunishingHitter) / 21.0
  }
  
  def ComputeFutureWlbRating: Double = {
    (futurePassRush * 10 +
      futurePassRushStrength * 6 +
      futureRunDefense * 4 +
      futureZoneDefense * 0.5 +
      futureManToManDefense * 0.5 +
      futureBumpAndRunDefense * 0.5 +
      futurePlayDiagnosis * 2 +
      futurePunishingHitter) / 24.5
  }
}
