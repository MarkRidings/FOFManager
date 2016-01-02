package Data.Queries

object LinebackerQueries extends FreeAgentQueriesBase {

  val attributes =
    """
       pi.first_name || ' ' || pi.last_name AS name,
       ti.home_city AS team,
       pc.mentor,
       pc.experience,
       pi.position,
       r.current_pass_rush_technique,
       r.current_pass_rush_strength,
       r.current_run_defense,
       r.current_zone_defense,
       r.current_man_to_man_defense,
       r.current_bump_and_run_defense,
       r.current_play_diagnosis,
       r.current_punishing_hitter,
       r.future_pass_rush_technique,
       r.future_pass_rush_strength,
       r.future_run_defense,
       r.future_zone_defense,
       r.future_man_to_man_defense,
       r.future_bump_and_run_defense,
       r.future_play_diagnosis,
       r.future_punishing_hitter,
       r.current_overall,
       r.future_overall
    """.stripMargin

  def GetILBs: String = {

    val positions =
      """
         pi.position = 'SILB' OR pi.position = 'WILB' OR pi.position = 'MLB'
      """.stripMargin

    sql.format(attributes, positions)
  }

  def GetOLBs: String = {

    val positions =
      """
         pi.position = 'WLB' OR pi.position = 'SLB'
      """.stripMargin

    sql.format(attributes, positions)
  }
}
