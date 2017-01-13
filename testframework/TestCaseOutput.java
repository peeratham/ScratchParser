package testframework;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;

import org.apache.commons.io.IOUtils;

import programs.Parser;
import junit.framework.TestCase;

public abstract class TestCaseOutput extends TestCase {

	private PrintStream out;

	private ByteArrayOutputStream stream;

	protected void setUp() throws Exception {
		super.setUp();
		out = System.out;
		stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream, true);
		System.setOut(printStream);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		if (System.out != null && System.out != out) {
			System.setOut(out);
		}
		stream.close();
		stream = null;
	}

	public void assertOutput(String result) {
		assertOutput("", result);
	}

	public void assertOutput(String msg, String result) {
		assertEquals(msg, result, stream.toString());
	}

	public void assertOutput(File file) {
		assertOutput("", file);
	}

	public void assertOutput(String msg, File file) {
		try {
			InputStream in = Parser.class.getClassLoader()
					.getResource(file.toString()).openStream();
			String string = IOUtils.toString(in);
//			String string = FileUtils.readFileToString(file);
		
			assertOutput(msg, string);
		} catch (FileNotFoundException e) {
			fail("File " + file.getName() + " not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}