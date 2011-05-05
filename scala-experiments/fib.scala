object Fib {

  def main(args: Array[String]) {
    val limit = args(0).toInt
    imperative(limit)
    recursive(limit)
  }

  def recursive(limit: Int) {
    def fib(current: Int, next: Int, counter: Int) {
      if (counter < limit) {
	println(current)
	fib(next, next + current, counter + 1)
      }
    }
    fib(0, 1, 0)
  }

  def imperative(limit: Int) {
    var current = 0
    var next = 1
    for (counter <- 0 until limit) {
      println(current)
      val tmp = next
      next = next + current
      current = tmp
    }
  }
}
