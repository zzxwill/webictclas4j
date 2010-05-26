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
 *��������ڴ�XML�ļ��л�ȡ���ֶ��������Ԫ�ء������ļ���Ϣ��
 * @author xuxiao
 */
public class GetFromXML {

    /**
     * �û�����XML�ļ������򿪲��ط����XML�ļ��ĸ�Ԫ�ء�һ��XML�ļ�ֻ��һ����Ԫ�ء�
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
     * ��ȡ���ݿ����ӵ�URL�����ݿ����������ļ���Ĭ��Ϊsetting.xml��
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
     * ��ȡ���ݿ�����ʱ�õ��û���username�����ݿ����������ļ���Ĭ��Ϊsetting.xml��
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
     * ��ȡ���ݿ������õ��û�����password�����ݿ����������ļ���Ĭ��Ϊsetting.xml��
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
     * �����õݹ�ķ���ʵ�ֶ�XML�ļ��ı�����
     * @param element
     */
    public static void treeWalk(Element element) {
	/**
	 * �����õݹ�ķ���ʵ��XML�ļ��ı���
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
