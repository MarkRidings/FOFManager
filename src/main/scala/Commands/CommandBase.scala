package Commands

abstract class CommandBase[T] {

  def Execute: T
}
