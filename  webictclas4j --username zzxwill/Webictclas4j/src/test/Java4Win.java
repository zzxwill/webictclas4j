package test;

import java.io.*;
public class Java4Win {

private void run(){
   Runtime ru=Runtime.getRuntime();
     try {
         // ���ò������ļ�����ָ��MP3
        // Process p1 = ru.exec("C:\\Program Files\\Windows Media Player\\wmplayer D:\\rascal\\music\\mp3\\��̫��.mp3");
        // �����������ļ�
         //Process p2 = ru.exec("d:\\a.bat");

     //����windowsͼƬ�ʹ���鿴��
  //     String cmd="rundll32.exe C:\\WINDOWS\\system32\\shimgvw.dll,ImageView_Fullscreen e:\\a.tif";

       /*
        * 
        */
    	 String url="F:\\Movie\\Precious\\��������ıɱ��.����.avi";
    	 String cmd="F:\\AAA Previous E\\Program Files\\Tencent\\QQPlayer\\QQPlayer.exe "+url;
       
     Process p2=ru.exec(cmd);

     } catch (IOException ex) {ex.printStackTrace();}
}
public static void main(String [] arg){
   Java4Win jw=new Java4Win();
   jw.run();
}

}

