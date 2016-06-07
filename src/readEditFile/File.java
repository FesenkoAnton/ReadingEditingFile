package readEditFile;

public class File {
private String words;
private int num;
public File(String word){
	this.words=word;
	num = 1;
}
public void countWord(){
	num++;
}
public String getWords(){
	return words;
}

public String toString(){
	return words+" "+num;
}

}
