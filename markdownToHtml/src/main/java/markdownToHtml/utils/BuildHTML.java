package markdownToHtml.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
 

public class BuildHTML {

	public static String buildHTMLContent(final String markdownHtml) {

		return "<!doctype html>\n" + "	<html>\n"
				+ "		<head>\n" + "			<meta charset=\"utf-8\"/>\n"
				+ "			<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\"/>\n"
				+ "			<style type=\"text/css\">\n"
				+ "				body { font-family: 'Inter', sans-serif; margin: 16px }\n"
				+ "				img { width: 100%; }\n"
				+ "				pre { white-space: pre-wrap; word-wrap: break-word }\n"
				+ "			</style>\n" + "		</head>\n"
				+ "		<body>\n" + markdownHtml + "		</body>\n" + "	</html>";
	}

	public static String getFileContent(final String fileName) {
		final InputStream is = getFileFromResourceAsStream(fileName);
		return printInputStream(is);
	}

	private static InputStream getFileFromResourceAsStream(final String fileName) {
		// The class loader that loaded the class
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(fileName);
		// the stream holding the file content
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {
			return inputStream;
		}

	}

	private static String printInputStream(InputStream is) {
		StringBuilder builder = new StringBuilder();

		try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader)) {
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}
	
	public static void WriteFileHtml(String markdownFile, String name) {
		final File file = new File(name+".html");
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(markdownFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ok");
	}

}
