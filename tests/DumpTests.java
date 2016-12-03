package tests;

import java.io.*;

import org.apache.commons.io.IOUtils;

import AST.Start;
import programs.Dumper;
import programs.Parser;
import testframework.TestCaseOutput;

public class DumpTests extends TestCaseOutput {
	private void assertDumpTest(String inputFileName, String resultName) {
		String[] args = new String[] { inputFileName };
		Dumper.main(args);
		assertOutput(new File(resultName));
	}

	public void testAllSyntax() throws IOException {
		assertDumpTest("tests/allsyntax.scratch", "tests/allsyntax.res");
	}
}
