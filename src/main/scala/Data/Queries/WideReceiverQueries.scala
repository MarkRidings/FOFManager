package Data.Queries

object WideReceiverQueries extends FreeAgentQueriesBase {

  def GetWRs: String = {

    val attributes =
      """
         pi.first_name || ' ' || pi.last_name as name,
         ti.home_city as team,
         pc.mentor,
         pc.experience,
         r.current_avoid_drops,
         r.current_get_downfield,
         r.current_route_running,
         r.current_third_down_receiving,
         r.current_big_play_receiving,
         r.current_courage,
         r.current_adjust_to_ball,
         r.future_avoid_drops,
         r.future_get_downfield,
         r.future_route_running,
         r.future_third_down_receiving,
         r.future_big_play_receiving,
         r.future_courage,
         r.future_adjust_to_ball,
         r.current_overall,
         r.future_overall
      """.stripMargin

    val positions =
      """
         pi.position = 'SE' OR pi.position = 'FL'
      """.stripMargin

    sql.format(attributes, positions)
  }

}
