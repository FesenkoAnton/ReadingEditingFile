package readEditFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Написати програму, що зчитує інформацію з текстового файлу і рахує кількість
 * слів в файлі, кількість унікальних слів в файлі, виводить інформацію про
 * кількість слів, кількість унікальних слів, унікальні слова за алфавітом і
 * поруч скільки разів це слово зустрілося. Унікальні слова - це, так би мовити,
 * словарний запас файлу. Тобто, якщо у вас у файлі сто слів, але при цьому там
 * двадцять п'ять різних слів, кожне з яких повторюється чотири рази, то
 * унікальних слів - 25.
 * 
 * Продумати ієрархію класів.
 * 
 * @author Anton
 *
 */

public class Select {
	private File file[] = new File[20];
	private int allWords = 0;
	private int words = 0;
	private int uniqueWord = 0;
	
	public void check(String word) {
		allWords++;
		File file = searchWord(word);
		if (file == null) {
			addWord(word);
			uniqueWord++;
		} else {
			file.countWord();
		}
	}

	public void order() {
		for (int i = 0; i < file.length - 1; i++) {
            for (int j = i+1; j < file.length; j++) {
                if ((file[j].getWords()).compareTo(file[i].getWords())<0) {
                    File temp = file[i];
                    file[i] = file[j];
                    file[j] = temp;
                    }
            }
        }
	}

	private File searchWord(String word) {
		for (int i = 0; i < words; i++)
			if (file[i].getWords().equals(word))
				return file[i];
		return null;
	}

	private void addWord(String word) {
		if (words >= file.length)
			resize(file.length * 2);
		file[words++] = new File(word);
	}

	private void resize(int num) {
		File[] temp = new File[num];
		for (int i = 0; i < file.length; i++)
			temp[i] = file[i];
		file = temp;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Summary words:").append(allWords + "\n")
				.append("Unique words: " + uniqueWord + "\n");
		
		for (int i = 0; i < words; i++)
			sb.append(file[i]).append("\n");
		return sb.toString();
	}

}