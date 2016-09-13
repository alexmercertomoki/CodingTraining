package com.soft.util;

import java.io.File;

public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("D:\\workspace07\\test\\upload03\\01\\02");
		if(!file.exists()){
			file.mkdirs();
		}
	}

}
