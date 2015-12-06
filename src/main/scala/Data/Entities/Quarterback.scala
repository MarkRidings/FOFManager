package Data.Entities

import java.sql.ResultSet

case class Quarterback (result: ResultSet) {
  
  val name = result.getString("name")
  val team = result.getString("team")
  val mentor = result.getInt("mentor")
  val exp = result.getInt("experience")
  
  val currentScreenPass = result.getInt("current_screen_passes")
  val currentShortPass = result.getInt("current_short_passes")
  val currentMediumPass = result.getInt("current_medium_passes")
  val currentLongPass = result.getInt("current_long_passes")
  val currentDeepPass = result.getInt("current_deep_passes")
  val currentThirdDown = result.getInt("current_third_down")
  val currentReadDefense = result.getInt("current_read_defense")
  val currentAccuracy = result.getInt("current_accuracy")
  val currentSenseRush = result.getInt("current_sense_rush")
  val currentOverall = result.getInt("current_overall")

  val futureScreenPass = result.getInt("future_screen_passes")
  val futureShortPass = result.getInt("future_short_passes")
  val futureMediumPass = result.getInt("future_medium_passes")
  val futureLongPass = result.getInt("future_long_passes")
  val futureDeepPass = result.getInt("future_deep_passes")
  val futureThirdDown = result.getInt("future_third_down")
  val futureReadDefense = result.getInt("future_read_defense")
  val futureAccuracy = result.getInt("future_accuracy")
  val futureSenseRush = result.getInt("future_sense_rush")
  val futureOverall = result.getInt("future_overall")
  
  def ComputeCurrentRating: Double = {
    (currentScreenPass * 3 +
    currentShortPass * 2 +
    currentMediumPass * 10 +
    currentLongPass * 0.5 +
    currentDeepPass * 0.5 +
    currentThirdDown * 16 +
    currentReadDefense * 8 +
    currentAccuracy * 8 +
    currentSenseRush * 15) / 63.0
  }
  
  def ComputeFutureRating: Double = {
    (futureScreenPass * 3 +
    futureShortPass * 2 +
    futureMediumPass * 10 +
    futureLongPass * 0.5 +
    futureDeepPass * 0.5 +
    futureThirdDown * 16 +
    futureReadDefense * 8 +
    futureAccuracy * 8 +
    futureSenseRush * 15) / 63.0
  }

}
