package jaca;

import jaca.parser.*;
import jaca.lexer.*;
import jaca.node.*;
import java.io.*;


public class Main {

	public static void main(String[] args) {
		try
		{
			String arquivo = "teste/produtos.jaca";

			Lexer lexer = new Lexer(new PushbackReader(new FileReader(arquivo), 1024));
			Token token;
			while(!((token = lexer.next()) instanceof EOF))
			{
				System.out.print(token.getClass());
				System.out.println(" ( "+token.toString()+")");
			}

			System.out.println("");

  			Parser p = new Parser(new Lexer(new PushbackReader(new FileReader(arquivo), 1024)));

			Start tree = p.parse();
			
   			tree.apply(new ASTPrinter());
   			//tree.apply(new ASTDisplay());
            tree.apply(new Semantico());
            
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}