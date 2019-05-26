import java.io.*;

public class InputDataTest {
    static private String s ="";
    public static void main(String argv[]){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            s = input.readLine();
            System.out.println(s);
        }
        catch (IOException ex){

        }
    }
}
