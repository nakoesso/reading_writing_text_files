package com.akoele.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingFiles {

	public static void main(String[] args) {
		Path path = Path.of("files/sonnet-ISO.txt");

		if (Files.exists(path)){
			try(BufferedReader bufferedReader = Files.newBufferedReader(path)) {
				String line = bufferedReader.readLine();
				while (line != null){
					System.out.println("Line = "+ line);
					line = bufferedReader.readLine();
				}

			}catch (IOException exception){
				exception.printStackTrace();
			}

		}

	}
}








