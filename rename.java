package test2;
import java.io.File;
import java.io.IOException;

public class rename {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\86175\\Pictures\\neg"; // 修改为你的文件夹路径
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        for(int i=0;i<files.length;i++) {
        	files[i].renameTo(new File("C:\\Users\\86175\\Pictures\\neg\\"+(i+1)+".jpg"));
        }
        }
    }
