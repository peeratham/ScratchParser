/*
 * Created on 2005-mar-10
 *
 */
package programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import tests.DumpTests;
import AST.ScratchParser;
import AST.ParseException;
import AST.Start;

/**
 * @author gorel
 *
 */
public class Parser {

	protected static Start parse(String args[]) {
		// Reader r = getReader(args);
		File f = new File(args[0]);
		Reader r = getReader2(f);
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

	public static Reader getReader2(File f) {
		Reader r = null;

		InputStream in;
		try {
			in = Parser.class.getClassLoader()
					.getResource(f.getPath()).openStream();
			r = new BufferedReader(
					new InputStreamReader(in));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}

	private static Reader getReader(String[] args) {
		Reader r = null;
		if (args.length != 1) {
			r = new InputStreamReader(System.in);
		} else {
			try {
				r = new FileReader(args[0]);
			} catch (FileNotFoundException e1) {
				System.err.println("Dumper: file " + args[0] + " not found");
			}
		}
		return r;
	}

}
