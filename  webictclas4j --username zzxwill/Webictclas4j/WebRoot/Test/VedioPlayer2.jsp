<%@   page   contentType="text/html;charset=gb2312"   language="java"   %>   
  <HTML><HEAD><TITLE>ActiveMovie   Embedded   MPG   Object   Test   Page</TITLE></HEAD>   
  <BODY>   
  <%   
        String   title=(String)request.getParameter("id");   
  %>   
   <object   id="video"   width="400"   height="200"   border="0"   classid="clsid:cfcdaa03-8be4-11cf-b84b-0020afbbccfa">   
  <param   name="showdisplay"   value="0">   
  <param   name="showcontrols"   value="1">   
  <param   name="autostart"   value="1">   
  <param   name="autorewind"   value="0">   
  <param   name="playcount"   value="0">   
  <param   name="appearance   value="0   value=""">   
  <param   name="borderstyle   value="0   value=""">   
  <param   name="moviewindowheight"   value="240">   
  <param   name="moviewindowwidth"   value="320">   
  <param   name="filename"   value="D:\\test1.avi">   
  <embed   width="400"   height="200"   border="0"   showdisplay="0"   showcontrols="1"   autostart="1"   autorewind="0"   playcount="0"   moviewindowheight="240"   moviewindowwidth="320"   filename="file:///d|/work/vod/mbar.avi"   src="mbar.avi">   
  </embed>     
  </object>   



</BODY></html>   
