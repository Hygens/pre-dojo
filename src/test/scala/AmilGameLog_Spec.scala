import com.amil.gamelog.AmilGameLog
import org.scalatest._

class AmilGameLog_in_Scala_Test_Spec extends FlatSpec with Matchers {
  "Testing AmilGameLog" should "valid path for log file" in {
      val filePath = "./../resources/In/gamers.log"
      AmilGameLog.main(Array(filePath))
  }
  it should "throw FileNotFoundException or NullPointerException if resource or file not found and show message in portuguese" in {
      val filePath = "./../resources/In/gamers1.log"
      AmilGameLog.main(Array(filePath))      
  }
  it should "throw Exception if file empty " in {
      val filePath = "./../resources/In/gamers_empty.log"
      AmilGameLog.main(Array(filePath))      
  }
}


