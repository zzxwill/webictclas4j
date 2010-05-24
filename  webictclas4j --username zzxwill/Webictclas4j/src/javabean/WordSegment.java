package javabean;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import keywords.GetKeywords;

public class WordSegment {
	private String inputText="";

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	
	
	public void wordseg() throws FileNotFoundException, UnsupportedEncodingException{
		GetKeywords getKeywords=new GetKeywords();
		getKeywords.getKeywordsMain4Web();
		System.out.println("inputText:"+inputText);
		
	}

}
