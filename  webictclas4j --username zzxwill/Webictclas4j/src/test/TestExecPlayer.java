package test;
import java.io.IOException;

public class TestExecPlayer {
    public static void main(String args[]){
        String thePlayerPath = "C:\\Program Files\\Windows Media Player\\wmplayer.exe"; /*��������·��*/
        try{
        Process ps = Runtime.getRuntime().exec(thePlayerPath);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}