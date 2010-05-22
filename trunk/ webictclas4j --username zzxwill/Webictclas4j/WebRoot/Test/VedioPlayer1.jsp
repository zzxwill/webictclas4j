<%@ page contentType="text/html;charset=GBK" %>
<html>
<head>
<title>在JSP中调用ActiveX控件播放媒体文件</title>
</head>
<body>
<%
    String fileName = "d:\\test1.avi";
    if(fileName.matches("\\w+\\.rm$")) {
%>
<object width="512" height="400" classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
    <param name="CONTROLS" value="ImageWindow">
    <param name="CONSOLE" value="Video">
    <param name="CENTER" value="TRUE">
    <param name="MAINTAINSPECT" value="TRUE">
</object>
<br>
<object width="512" height="30" classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
    <param name="CONTROLS" value="ControlPanel">
    <param name="CONSOLE" value="Video">
    <param name="SRC" value="<%out.print(fileName);%>">
    <param name="AUTOSTART" value="TRUE">
    <param name="PREFETCH" value="0">
    <param name="LOOP" value="0">
    <param name="NUMLOOP" value="0">
</object>
<br>
<object width="512" height="20" classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
    <param name="CONTROLS" value="StatusBar">
    <param name="CONSOLE" value="Video">
</object>
<%
    }else{
%>
<object
    align=middle
    classid=CLSID:22d6f312-b0f6-11d0-94ab-0080c74c7e95
    class=OBJECT id=MediaPlayer width=384 height=348 >
        <param name=ShowStatusBar value=1>
        <param name=Filename value="<%out.print(fileName);%>">
</object>
<%
    }
%>
</body>
</html>


