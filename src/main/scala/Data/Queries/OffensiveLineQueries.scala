package Data.Queries

object OffensiveLineQueries extends FreeAgentQueriesBase {

  val attributes =
    """
       pi.first_name || ' ' || pi.last_name as name,
       ti.home_city as team,
       pc.mentor,
       pc.experience,
       pi.position,
       r.current_run_blocking,
       r.current_pass_blocking,
       r.current_blocking_strength,
       r.current_endurance,
       r.future_run_blocking,
       r.future_pass_blocking,
       r.future_blocking_strength,
       r.future_endurance,
       r.current_overall,
       r.future_overall
    """.stripMargin

  def GetCs: String = {

    val positions =
      """
         pi.position = 'C'
      """.stripMargin

    sql.format(attributes, positions)
  }

  def GetOGs: String = {

    val positions =
      """
         pi.position = 'LG' OR pi.position = 'RG'
      """.stripMargin

    sql.format(attributes, positions)
  }

  def GetOTs: String = {

    val positions =
      """
       pi.position = 'LT' OR pi.position = 'RT'
    """.stripMargin

    sql.format(attributes, positions)
  }
}
