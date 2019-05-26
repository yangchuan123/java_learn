import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleFileWriter {
    public static void main(String argv[]){
        try{
            FileOutputStream out = new FileOutputStream("text.txt");
            out.write("testtesetst".getBytes());
            out.close();
        }
        catch (FileNotFoundException ioe){

        }
        catch (IOException ex){

        }
    }
}
