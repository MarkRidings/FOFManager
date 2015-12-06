package Data.Queries

abstract class FreeAgentQueriesBase {

  val sql =
    """
       SELECT
          %s
        FROM
          players_personal r
          INNER JOIN player_information pi ON pi.player_id = r.player_id
          LEFT JOIN player_record pc ON pc.player_id = r.player_id
          LEFT JOIN team_information ti ON ti.team = pc.team
        WHERE
          %s
          AND pc.contract_length = 0
          AND (pc.experience > 4 OR ti.home_city is null)
    """.stripMargin

}
