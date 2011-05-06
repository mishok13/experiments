package poker {
  import scala.actors._
  import scala.actors.Actor._

  abstract class PokerAction() {
    def show(): Unit
  }

  class Raise(value: Int) extends PokerAction {
    def show() = println("raise by " + value.toString)
  }

  class Check() extends PokerAction {
    def show() = println("check")
  }

  class Pass() extends PokerAction {
    def show() = println("pass")
  }

  object PokerActor extends Actor {
    def act() {
      loop {
	receive {
	  case action: PokerAction => action.show()
	  case "exit" => println("exit"); exit
	  case other: Any => println("WTF: " + other)
	}
      }
    }
  }
}
