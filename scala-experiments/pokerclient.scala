import poker._


PokerActor.start()

println("Started")

PokerActor ! new Check
PokerActor ! new Pass
PokerActor ! new Raise(2)
PokerActor ! new Raise(0)
PokerActor ! 5

PokerActor ! "exit"
