package javabean;

public class WordSegment {
	private String inputText="";

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}
	
	
	public void wordseg(){
		System.out.println(inputText);
	}

}
