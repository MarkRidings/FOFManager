package Commands

import Data.DatabaseManager
import Data.Queries.{QuarterbackFreeAgentQuery, RunningBackFreeAgentQuery}
import Displays.PlayerDisplay

case class DisplayFreeAgentsCommand(pos: Array[String], db: DatabaseManager) extends CommandBase[DisplayFreeAgentsResult] {

  val positions = pos

  override def Execute: DisplayFreeAgentsResult = {

    positions.foreach(p => p.toLowerCase match {
      case "qb" =>
        val result = db.Select(QuarterbackFreeAgentQuery.GetQBs)
        println("QB")
        PlayerDisplay.BasicQB(result)

      case "rb" =>
        val result = db.Select(RunningBackFreeAgentQuery.GetRBs)
        println("RB")
        PlayerDisplay.BasicRB(result)

      case _ => println(s"$p is not a valid position")

    })

    null
  }
}
