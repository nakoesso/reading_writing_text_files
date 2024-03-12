package com.akoele.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingFiles {
	
	public static void main(String... args) {
		
		Path path = Path.of("files/debug.log");
		
		try(BufferedWriter writer = Files.newBufferedWriter(path)) {
			 writer.write("Hello");

		}catch (IOException e){
			e.printStackTrace();
		}

	}

}







