/*
 * Created on 2005-mar-09
 *
 */
package programs;

import AST.Start;

public class Dumper extends Parser {
	public static void main(String args[]) {
		Start ast = parse(args);

		// Dump the AST
		ast.dumpTree("  ", System.out);
	}
}