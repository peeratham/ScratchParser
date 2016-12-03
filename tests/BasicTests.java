/*
 * Created on 2005-mar-10
 *
 */
package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import AST.Start;
import testframework.TestCaseParse;


public class BasicTests extends TestCaseParse {
	public void testParseString() {
		Start ast = parse("{<[(a,b,s)],[(a,b,s)]>}");
		ast.dumpTree("  ", System.out);
//		System.out.print(ast.print());
		
	}
	
	public void testParseFromFile() throws IOException {
		InputStream in = BasicTests.class.getClassLoader()
				.getResource("tests/allsyntax.scratch").openStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(in));
		String a = reader.readLine();
		reader.close();
		Start ast = parse(a);
		System.out.print(ast.print());
	}

}