package Data.Queries

/**
  * Created by MarkR on 12/6/2015.
  */
object QuarterbackFreeAgentQuery extends FreeAgentQueriesBase {

  def GetQBs: String = {

    val attributes =
      """
         pi.first_name || ' ' || pi.last_name AS name,
         ti.home_city AS team,
         r.current_screen_passes,
         r.current_short_passes,
         r.current_medium_passes,
         r.current_long_passes,
         r.current_deep_passes,
         r.current_third_down,
         r.current_read_defense,
         r.current_accuracy,
         r.current_sense_rush,
         r.future_screen_passes,
         r.future_short_passes,
         r.future_medium_passes,
         r.future_long_passes,
         r.future_deep_passes,
         r.future_third_down,
         r.future_read_defense,
         r.future_accuracy,
         r.future_sense_rush,
         r.current_overall,
         r.future_overall,
         pc.mentor,
         pc.experience
      """.stripMargin

    val positions =
      """
        pi.position = 'QB'
      """.stripMargin

    sql.format(attributes, positions)
  }

}
