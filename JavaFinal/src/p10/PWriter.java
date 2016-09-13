package p10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PWriter {
	public static void main(String[] args) {
	try {
		 
		String content = "This is the content to write into file";

		File file = new File("filename.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getPath());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();// flush the rest   not close not save 

		System.out.println("Done");

	} catch (IOException e) {
		e.printStackTrace();
	 }
    }
}
