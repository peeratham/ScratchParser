/*
 * Created on 2005-mar-10
 *
 */
package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import programs.Parser;
import AST.Start;
import junit.framework.TestCase;


public class BasicTests  extends TestCase{
	public void testParseString() {
		Start ast = Parser.parse("{<[(a,b,s)],[(a,b,s)]>}");
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
		Start ast = Parser.parse(a);
//		System.out.print(ast.print());
	}

}