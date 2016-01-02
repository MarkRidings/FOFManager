package Commands

import Data.DatabaseManager
import Data.Queries._
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

      case "te" =>
        val result = db.Select(TightEndFreeAgentQueries.GetTEs)
        println("TE")
        PlayerDisplay.BasicTE(result)

      case "wr" =>
        val result = db.Select(WideReceiverQueries.GetWRs)
        println("WR")
        PlayerDisplay.BasicWR(result)

      case "c" =>
        val result = db.Select(OffensiveLineQueries.GetCs)
        println("C")
        PlayerDisplay.BasicOL(result)

      case "g" =>
        val result = db.Select(OffensiveLineQueries.GetOGs)
        println("G")
        PlayerDisplay.BasicOL(result)

      case "t" =>
        val result = db.Select(OffensiveLineQueries.GetOTs)
        println("T")
        PlayerDisplay.BasicOL(result)

      case "ol" =>
        DisplayFreeAgentsCommand(Array[String]("c", "g", "t"), db).Execute

      case "de" =>
        val result = db.Select(DefensiveLineQueries.GetDEs)
        println("DE")
        PlayerDisplay.BasicDL(result)

      case "dt" =>
        val result = db.Select(DefensiveLineQueries.GetDTs)
        println("DT")
        PlayerDisplay.BasicDL(result)

      case "dl" =>
        DisplayFreeAgentsCommand(Array[String]("de", "dt"), db).Execute

      case "ilb" =>
        val result = db.Select(LinebackerQueries.GetILBs)
        println("ILB")
        PlayerDisplay.BasicILB(result)

      case "olb" =>
        val result = db.Select(LinebackerQueries.GetOLBs)
        println("OLB")
        PlayerDisplay.BasicOLB(result)

      case "lb" =>
        DisplayFreeAgentsCommand(Array[String]("ilb", "olb"), db).Execute

      case _ => println(s"$p is not a valid position")

    })

    null
  }
}
