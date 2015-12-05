package Data


case class DatabaseManager (league: String) {

  val db = PostgresDatabaseConnection(league)

}
