package hanoi

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class HanoiTest extends FunSuite with ShouldMatchers {

  test("7 moves for 3 discs") {
    runTest(3,
    List(          //    1-2-3   -    -
        (1, 3),    //     2-3    -    1
        (1, 2),    //      3     2    1
        (3, 2),    //      3    1-2   -
        (1, 3),    //      -    1-2   3
        (2, 1),    //      1     2    3
        (2, 3),    //      1     -   2/3
        (1, 3)     //      -     -  1/2/3  
    ))
  }
  
  test("15 moves for 4 discs") {
    runTest(4, List((1, 2), (1, 3), (2, 3), (1, 2), (3, 1), (3, 2), (1, 2), (1, 3), (2, 3), (2, 1), (3, 1), (2, 3), (1, 2), (1, 3), (2, 3)))
  }
  
  private[HanoiTest] def runTest(n: Int, expected: List[(Int, Int)]) {
    val result = Hanoi(n)
    result.size shouldEqual expected.size

    expected.zip(result).foreach {
      case ((expectedFrom, expectedTo), (actualFrom, actualTo)) =>
        actualFrom shouldEqual expectedFrom
        actualTo shouldEqual expectedTo
    }
  }
}