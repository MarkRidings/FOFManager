package Data.Queries

object DefensiveLineQueries extends FreeAgentQueriesBase {

  val attributes =
    """
       pi.first_name || ' ' || pi.last_name AS name,
       ti.home_city as team,
       pc.mentor,
       pc.experience,
       pi.position,
       r.current_pass_rush_technique,
       r.current_pass_rush_strength,
       r.current_run_defense,
       r.current_play_diagnosis,
       r.current_punishing_hitter,
       r.future_pass_rush_technique,
       r.future_pass_rush_strength,
       r.future_run_defense,
       r.future_play_diagnosis,
       r.future_punishing_hitter,
       r.current_overall,
       r.future_overall
    """.stripMargin

  def GetDEs: String = {
    val positions =
      """
         pi.position = 'LDE' OR pi.position = 'RDE'
      """.stripMargin

    sql.format(attributes, positions)
  }

  def GetDTs: String = {
    val positions =
      """
         pi.position = 'LDT' OR pi.position = 'RDT' OR pi.position = 'NT'
      """.stripMargin

    sql.format(attributes, positions)
  }
}
