package hanoi

private class Hanoi {

  type Move = (Int, Int)
  private[Hanoi] def move(n: Int): List[Move] = {
    
    def moveOne(from: Int, to: Int): List[Move] = List((from, to))
    
    def moveN(n: Int, from: Int, to: Int): List[Move] = {
      if (n == 1) moveOne(from, to)
      else {
        val other = 6 - from - to
        moveN(n - 1, from, other) ++ moveOne(from, to) ++ moveN(n - 1, other, to)
      }
    }
    
    moveN(n, 1, 3)
  }
}

object Hanoi {
  def apply(n: Int) = new Hanoi().move(n)
}