import UserInterface.Cli

/**
  * Created by MarkR on 12/3/2015.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val cli = new Cli()
    cli.DisplayWelcome()
    cli.GetInput()
  }

}
