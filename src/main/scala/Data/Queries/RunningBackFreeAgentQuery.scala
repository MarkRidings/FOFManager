package Data.Queries

object RunningBackFreeAgentQuery extends FreeAgentQueriesBase{

  def GetRBs: String = {
    val attributes =
      """
         pi.first_name || ' ' || pi.last_name AS name,
         ti.home_city AS team,
         r.current_speed,
         r.current_power_inside,
         r.current_third_down_runs,
         r.current_hole_recognition,
         r.current_elusiveness,
         r.current_speed_outside,
         r.current_avoid_drops,
         r.current_get_downfield,
         r.current_route_running,
         r.current_overall,
         r.future_overall,
         r.future_speed,
         r.future_power_inside,
         r.future_third_down_runs,
         r.future_hole_recognition,
         r.future_elusiveness,
         r.future_speed_outside,
         r.future_avoid_drops,
         r.future_get_downfield,
         r.future_route_running,
         pc.mentor,
         pc.experience
      """.stripMargin

    val positions =
      """
         pi.position = 'RB'
      """.stripMargin

    sql.format(attributes, positions)
  }
}
