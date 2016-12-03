/*
 * Created on 2005-mar-10
 *
 */
package testframework;

import java.io.Reader;
import java.io.StringReader;

import AST.ScratchParser;
import AST.ParseException;
import AST.Start;
import junit.framework.TestCase;

/**
 * @author gorel
 *
 */
public abstract class TestCaseParse extends TestCase {

	protected static Start parse(String s) {
		Reader r = new StringReader(s);
		Start ast = null;
		try {
			ScratchParser parser = new ScratchParser(r);

			// Start parsing from the nonterminal "Start".
			ast = parser.Start();
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return ast;
	}

}
