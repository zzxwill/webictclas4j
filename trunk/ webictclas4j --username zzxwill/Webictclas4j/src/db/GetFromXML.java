/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

/**
 *这个类用于从XML文件中获取各种东西。如根元素、配置文件信息等
 * @author xuxiao
 */
public class GetFromXML {

    /**
     * 用户给出XML文件名，打开并回返这个XML文件的根元素。一个XML文件只有一个根元素。
     * @param inputfile
     * @return
     */
    public static Element openXML(String inputfile) {
	SAXReader reader = new SAXReader();
	Document document = null;
	Element element = null;
	try {
	    document = reader.read(new File(inputfile));
	} catch (DocumentException ex) {
	    Logger.getLogger(GetFromXML.class.getName()).log(Level.SEVERE, null, ex);
	    return null;
	}
	element = document.getRootElement();
	return element;
    }

    /**
     * 获取数据库连接的URL。数据库连接配置文件名默认为setting.xml。
     *
     * @return
     */
    public static String getDbURL() {
	String settingfile = "setting.xml";
	Element root = openXML(settingfile);
	Element tmpe1 = null;
//	Element tmpe2 = null;
	Iterator i = root.elementIterator();
//	Iterator j = null;

	while (i.hasNext()) {
	    tmpe1 = (Element) i.next();
	    if (tmpe1.getName().equals("url")) {
		return tmpe1.getText();
	    }
	}
	return null;
    }

    /**
     * 获取数据库连接时用的用户名username。数据库连接配置文件名默认为setting.xml。
     * @return
     */
    public static String getDbUsername() {
	String settingfile = "setting.xml";
	Element root = openXML(settingfile);
	Element tmpe1 = null;
//	Element tmpe2 = null;
	Iterator i = root.elementIterator();
//	Iterator j = null;

	while (i.hasNext()) {
	    tmpe1 = (Element) i.next();
	    if (tmpe1.getName().equals("username")) {
		return tmpe1.getText();
	    }
	}
	return null;
    }

    /**
     * 获取数据库连接用的用户密码password。数据库连接配置文件名默认为setting.xml。
     * @return
     */
    public static String getDbPassword() {
	String settingfile = "setting.xml";
	Element root = openXML(settingfile);
	Element tmpe1 = null;
//	Element tmpe2 = null;
	Iterator i = root.elementIterator();
//	Iterator j = null;

	while (i.hasNext()) {
	    tmpe1 = (Element) i.next();
	    if (tmpe1.getName().equals("password")) {
		return tmpe1.getText();
	    }
	}
	return null;
    }

    /**
     * 这是用递归的方法实现对XML文件的遍历。
     * @param element
     */
    public static void treeWalk(Element element) {
	/**
	 * 这是用递归的方法实现XML文件的遍历
	 */
	for (int i = 0, size = element.nodeCount(); i < size; i++) {
	    Node node = element.node(i);
	    if (node instanceof Element) {
		treeWalk((Element) node);
		System.out.println("node is Element, the name of the node is " + node.getName());
		System.out.println("the text of the node is " + node.getText());
	    } else {
//		System.out.println(node.getText());
	    }
	}
    }
}
