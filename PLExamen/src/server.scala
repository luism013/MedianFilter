import medianFilter.filter
import medianFilter.paralelFilter
import java.io.File
//import javax.imageio.ImageIO
//import akka.actor.Actor
//import akka.actor.ActorSystem
//import akka.actor.Props

object server{
  def main(args: Array[String]): Unit = {
    val f = new File("input.jpeg") //Input Photo File
    var inS = System.nanoTime()
    filter(f)
    var outS = System.nanoTime()
    println("Serial implementation execution time (in nanoseconds): "+timeCalculator(inS, outS))
    
    // parallel median filter
    var inP = System.nanoTime()
    paralelFilter(f)
    var outP = System.nanoTime()
    println("Parallel Collection execution time (in nanoseconds): "+timeCalculator(inP, outP))
    println("Picture results can be found in directory: eclipse-workspace/PLExam")

  }

  def timeCalculator(a:Long, b:Long): Long = {
    return b-a
  }

}
