import java.awt.Color
import java.io.File
import java.util
import javax.imageio.ImageIO
import scala.collection.parallel.mutable.ParArray
import java.awt.image.BufferedImage

object medianFilter {

	def filter(f: File){
			val pixel = new Array[Color](9)
					val R = new Array[Int](9)
					val B = new Array[Int](9)
					val G = new Array[Int](9)
					val output = new File(("SerialOutput.jpeg"))
					val img = ImageIO.read(f)
					var i = 1
					while ( {
						i < img.getWidth - 1
					}) {
						var j = 1
								while ( {
									j < img.getHeight - 1
								}) {
									pixel(0) = new Color(img.getRGB(i - 1, j - 1))
											pixel(1) = new Color(img.getRGB(i - 1, j))
											pixel(2) = new Color(img.getRGB(i - 1, j + 1))
											pixel(3) = new Color(img.getRGB(i, j + 1))
											pixel(4) = new Color(img.getRGB(i + 1, j + 1))
											pixel(5) = new Color(img.getRGB(i + 1, j))
											pixel(6) = new Color(img.getRGB(i + 1, j - 1))
											pixel(7) = new Color(img.getRGB(i, j - 1))
											pixel(8) = new Color(img.getRGB(i, j))
											var k = 0
											while ( {
												k < 9
											}) {
												R(k) = pixel(k).getRed
														B(k) = pixel(k).getBlue
														G(k) = pixel(k).getGreen

														{
													k += 1
															k - 1
														}
											}
									util.Arrays.sort(R)
									util.Arrays.sort(G)
									util.Arrays.sort(B)
									img.setRGB(i, j, new Color(R(4), B(4), G(4)).getRGB)

									{
										j += 1
												j - 1
									}
								}
						{
							i += 1
									i - 1
						}
					}
			ImageIO.write(img, "jpg", output)
//			f
	}

	def paralelFilter(f: File){
			val pixel = new ParArray[Color](9)
					val R = new ParArray[Int](9)
					val B = new ParArray[Int](9)
					val G = new ParArray[Int](9)
					val output = new File(("ParalelOutput.jpeg"))
					val img = ImageIO.read(f)
					var i=1
					for (i <- (1 to img.getWidth -1).par ){
						var j = 1
//								while ( {
//									j < img.getHeight - 1
//								}) {
						    for (j <- (1 to img.getWidth -1).par ){
									pixel(0) = new Color(img.getRGB(i - 1, j - 1))
											pixel(1) = new Color(img.getRGB(i - 1, j))
											pixel(2) = new Color(img.getRGB(i - 1, j + 1))
											pixel(3) = new Color(img.getRGB(i, j + 1))
											pixel(4) = new Color(img.getRGB(i + 1, j + 1))
											pixel(5) = new Color(img.getRGB(i + 1, j))
											pixel(6) = new Color(img.getRGB(i + 1, j - 1))
											pixel(7) = new Color(img.getRGB(i, j - 1))
											pixel(8) = new Color(img.getRGB(i, j))
											var k = 0
											//        while ( {
											//          k < 9
											for (k <- (0 to 9).par){
												R(k) = pixel(k).getRed
														B(k) = pixel(k).getBlue
														G(k) = pixel(k).getGreen

														{
//													k += 1
															k - 1
														}
											}
									util.Arrays.sort(R.toArray)
									util.Arrays.sort(G.toArray)
									util.Arrays.sort(B.toArray)
									img.setRGB(i, j, new Color(R(4), B(4), G(4)).getRGB)

									{
//										j += 1
												j - 1
									}
								}
						{
//						          i +=1
							        i - 1
						}
					}
			ImageIO.write(img, "jpeg", output)
	}

}
