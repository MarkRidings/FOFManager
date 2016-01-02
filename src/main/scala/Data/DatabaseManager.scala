package Data

import java.sql.ResultSet


case class DatabaseManager (league: String) {

  val db = PostgresDatabaseConnection(league)

  def Select(statement: String): Iterator[ResultSet] = {
    val tran = db.GetConn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    val result = tran.executeQuery(statement)

    new Iterator[ResultSet] {
      def hasNext = result.next()
      def next = result
    }
  }

  def Insert(statement: String): Int = {
    val tran = db.GetConn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)
    tran.executeUpdate(statement)
  }

  def Close(): Unit = {
    db.Close()
  }

}
