package net.mishkovskyi.chat


import java.net._
import java.io._
import java.util.UUID
import scala.actors._
import scala.actors.Actor._
import scala.collection.mutable.{ListBuffer}



class Member(val name: String,
	     val chat: Chat,
	     val reader: LineNumberReader,
	     val writer: OutputStreamWriter) extends Actor{

  def this(chat: Chat,
	   reader: LineNumberReader,
	   writer: OutputStreamWriter) = {
    this(reader.readLine(), chat, reader, writer)
  }

  def send(message: String) = {
    println("%s -> %s".format(name, message))
    writer.write("%s -> %s\n".format(name, message))
    writer.flush()
  }

  def act() {
    while (true) {
      val line = reader.readLine()
      chat ! (this, line)
    }
  }

}


class Chat extends Actor {

  val people = new ListBuffer[Member]

  def handle(sender: Member, msg: String) = {
    if (people.contains(sender)) {
      people.filter(_ != sender).foreach(_.send("%s: %s".format(sender.name, msg)))
    } else {
      sender.send("You're not inited yet")
    }
  }

  def init(sender: Member) = {
    println(sender)
    if (people.contains(sender)) {
      sender.send("You can't init twice")
    } else {
      people.foreach(_.send("New person: %s".format(sender.name)))
      people += sender
    }
  }

  def error(unknown: Any) = {
    println("Unkown message: %s".format(unknown))
  }


  def act() {
    loop {
      receive {
	case sender: Member => init(sender)
	case (sender: Member, msg: String) => handle(sender, msg)
	case unknown => error(unknown)
      }
    }
  }
}


class Dispatcher(val chat: Chat) extends Actor {

  def act() {
    loop {
      receive {
	case connection: Socket => handle(connection)
	case _ => println("Unknown")
      }
    }
  }

  def handle(connection: Socket) = {
    val reader = new LineNumberReader(new InputStreamReader(connection.getInputStream))
    val writer = new OutputStreamWriter(connection.getOutputStream)
    val member = new Member(chat, reader, writer)
    chat ! member
    member.start
  }

}


class Server(port: Int) {

  def start() = {

    val socket = new ServerSocket(2345)
    val chat = new Chat
    val dispatcher = new Dispatcher(chat)
    dispatcher.start
    chat.start

    while (true) {
      val connection = socket.accept()
      println(connection)
      dispatcher ! connection
    }
  }

}


object ChatApp {

  def main(args: Array[String]) {
    new Server(2345).start
    // val chat = new Chat
    // val andy = new Member("Andy")
    // val andy2 = new Member("Andy")
    // val bram = new Member("Bram")
    // println("Starting chat application")
    // chat.start
    // chat ! "test"
    // chat ! (andy, "init")
    // chat ! (andy2, "init")
    // chat ! (andy, "foo")
    // chat ! (bram, "hi all")
    // chat ! (bram, "init")
    // chat ! (bram, "hi all")
  }

}
