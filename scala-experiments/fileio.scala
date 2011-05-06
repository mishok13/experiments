val src = scala.io.Source.fromFile("input.txt")
val dest = new java.io.PrintWriter(new java.io.File("output.txt"))
// Read from source line by line and for each line print to file
src.getLines().foreach(dest.println(_))
dest.close()
src.close()
