package readEditFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class ReadRun {

	private Select select;

	ReadRun() {
		select = new Select();
	}

	public void parse(String nameOfFile) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new FileReader(nameOfFile)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			switch (st.ttype) {
			case StreamTokenizer.TT_WORD:
				select.check(st.sval);
				break;
			}
		}
		select.order();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(select);
		return sb.toString();
	}

	public static void main(String args[]) throws IOException {
		String nameOfFile;
		if (args.length != 1) {
			nameOfFile = "test.txt";
		} else {
			nameOfFile = args[0];
		}
		ReadRun readRun = new ReadRun();
		readRun.parse(nameOfFile);
		System.out.println(readRun);
	}
}
