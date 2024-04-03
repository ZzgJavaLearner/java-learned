package test2;

import java.io.File;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
                         //file->mat->灰度化->
public class doImages {
    public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		File file=new File("C:\\Users\\86175\\Pictures\\neg");
		System.out.println(file.isDirectory());
		File[] files=file.listFiles();
		System.out.println(files.length);
		String path="C:\\Users\\86175\\Pictures\\neg\\JPEG";
		for(int i=1;i<=96;i++) {
			Mat mat=Imgcodecs.imread(path+"\\"+i+".jpg");
			 Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2GRAY);   //转化为灰度图
			 Imgcodecs.imwrite(path+"\\"+(i+103)+".jpg",mat);
			 System.out.println(i);
		}
		
		
	}
}
