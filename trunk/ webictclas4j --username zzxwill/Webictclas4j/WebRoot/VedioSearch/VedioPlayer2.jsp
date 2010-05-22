<%@   page contentType="text/html;charset=gb2312" language="java"%>
<HTML>
	<HEAD>
		<TITLE>ActiveMovie Embedded MPG Object Test Page</TITLE>
	</HEAD>
	<BODY>
		<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
			codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0"
			width="640" height="375" id="FlvPlayer" align="middle">
			<param name="allowScriptAccess" value="sameDomain" />
			<param name="allowFullScreen" value="true" />
			<param name="movie"
				value="http://flvplayer.com/free-flv-player/FlvPlayer.swf" />
			<param name="quality" value="high" />
			<param name="bgcolor" value="FFFFFF" />
			<param name="FlashVars"
				value="flvpFolderLocation=http://flvplayer.com/free-flv-player/flvplayer/&flvpVideoSource=/Webictclas4j/Vedio/1 C Rolarodo.flv&flvpWidth=640&flvpHeight=375&flvpInitVolume=50&flvpTurnOnCorners=true&flvpBgColor=FFFFFF"
				< embed src="http://flvplayer.com/free-flv-player/FlvPlayer.swf" flashvars="flvpFolderLocation=http://flvplayer.com/free-flv-player/flvplayer/&flvpVideoSource=http://localhost:8080/Webictclas4j/Vedio/1 C Rolarodo.flv&flvpWidth=640&flvpHeight=375&flvpInitVolume=50&flvpTurnOnCorners=true&flvpBgColor=FFFFFF" quality="high" bgcolor="FFFFFF" width="640" height="375" name="FlvPlayer" align="middle" allowScriptAccess="sameDomain" allowFullScreen="true" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer" />
		
		
		</object>




	</BODY>
</html>
