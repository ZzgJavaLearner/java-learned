package test2;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.video.BackgroundSubtractor;
import org.opencv.video.Video;

public class collectImg {
   public static void main(String[] args) throws AWTException, IOException, InterruptedException {
	   collect("C:\\Users\\86175\\Pictures\\aaaa","jpg");
    		}
   
   //文件夹路径
   public static void collect(String path,String format) throws InterruptedException, AWTException, IOException {
	   System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	   
	      int i=0;
	    		while(true) {
	    		i++;
	    		Thread.sleep(3000);
	    			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    			Robot robot = new Robot();
	    			BufferedImage bufferedImage = robot.createScreenCapture(new Rectangle(d.width, d.height));
	    			ImageIO.write(bufferedImage, "jpg", new File(path+"\\" +i+ "."+format));
	    			System.out.println("ok");
   }
}
}

