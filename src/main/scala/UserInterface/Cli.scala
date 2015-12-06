package UserInterface

import Commands.DisplayFreeAgentsCommand
import Data.DatabaseManager
import FileHandling.FileIO
import scala.io.StdIn
import scala.util.Properties

class Cli {

  val newline = Properties.lineSeparator
  val welcomeMessage = "Welcome to FOF Manager!" + newline + "Please enter a command (type help for more details)"
  val file = new FileIO()
  var dbManager: DatabaseManager = null

  def DisplayWelcome(): Unit = {
    println(welcomeMessage)
  }

  def PerformCommand(line: String): Unit = line.split(' ').head match {
    case "list" =>
      file.ListDir()
      println()

    case "use" =>
      if (line.split(' ').length > 2) {
        println("ERROR: load only accepts one argument")
      }
      else if (line.split(' ').length < 2) {
        println("ERROR: load requires a league to load (either index or name)")
      }
      else {
        val dirInfo = file.GetDirectoryIndex(line.split(' ').last)
        if (dirInfo._1 > -1) {
          dbManager = DatabaseManager(dirInfo._2)
          println("USING: %s".format(dirInfo._2))
        }
        else {
          println("ERROR: league %s not found".format(line.split(' ').last))
        }
      }

      println()

    case "fa" =>
      val tokens = line.split(' ')
      val command = if (tokens.length == 1) DisplayFreeAgentsCommand(Array("All"), dbManager) else DisplayFreeAgentsCommand(tokens.tail, dbManager)
      val result = command.Execute

    case _ =>
      println(line)
      println()
  }

  def GetInput(): Unit = {
    Stream.continually(StdIn.readLine("> ")).takeWhile(_ != "quit") foreach { line =>
      PerformCommand(line)
    }
  }

}
