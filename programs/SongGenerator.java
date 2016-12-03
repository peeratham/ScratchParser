/*
 * Created on 2005-mar-09
 *
 */
package programs;

import AST.Start;

public class SongGenerator extends Parser {
	public static void main(String args[]) {
		Start ast = parse(args);

		// Generate a song frpm the AST
//		System.out.println(ast.print());
	}
}
