package decaf;

import java.io.*;
import antlr.Token;
import java6035.tools.CLI.*;

class Main {
    public static void main(String[] args) {
        try {
        	CLI.parse (args, new String[0]);
        	
        	InputStream inputStream = args.length == 0 ?
                    System.in : new java.io.FileInputStream(CLI.infile);

        	if (CLI.target == CLI.SCAN)
        	{
        		DecafScanner lexer = new DecafScanner(new DataInputStream(inputStream));
        		Token token;
        		boolean done = false;
        		while (!done)
        		{
        			try
        			{
		        		for (token=lexer.nextToken(); token.getType()!=DecafParserTokenTypes.EOF; token=lexer.nextToken())
		        		{
		        			String type = "";
		        			String text = token.getText();
		
		        			switch (token.getType())
		        			{
		        			case DecafScannerTokenTypes.ID:
		        				type = " IDENTIFIER";
		        				break;
							case DecafScannerTokenTypes.NUMERO:
		        				type = " NUMERO";
		        				break;
							case DecafScannerTokenTypes.TK_class:
		        				type = " CLASSE";
		        				break;
							case DecafScannerTokenTypes.TK_package:
		        				type = " PACOTE";
		        				break;	
							case DecafScannerTokenTypes.TK_protected:
		        				type = " TIPO DE SEGURANCA";
		        				break;
							case DecafScannerTokenTypes.TK_import:
		        				type = " IMPORT";
		        				break;
							case DecafScannerTokenTypes.TK_extends:
		        				type = " EXTENCAO DE CLASSE";
		        				break;
							case DecafScannerTokenTypes.TK_private:
		        				type = " TIPO DE SEGURANCA";
		        				break;
							case DecafScannerTokenTypes.TK_if:
		        				type = " EXPRESSAO IF";
		        				break;
							case DecafScannerTokenTypes.TK_else:
		        				type = " EXPRESSAO ELSE";
		        				break;
						    case DecafScannerTokenTypes.TK_for:
		        				type = " EXPRESSAO FOR";
		        				break;
							case DecafScannerTokenTypes.TK_do:
		        				type = " EXPRESSAO DO";
		        				break;
							case DecafScannerTokenTypes.TK_while:
		        				type = " EXPRESSAO WHILE";
		        				break;
							case DecafScannerTokenTypes.TK_int:
		        				type = " TIPO DE DADO";
		        				break;
							case DecafScannerTokenTypes.TK_double:
		        				type = " TIPO DE DADO";
		        				break;
							case DecafScannerTokenTypes.TK_float:
		        				type = " TIPO DE DADO";
		        				break;
							case DecafScannerTokenTypes.TK_return:
		        				type = " RETORNO DE METODO";
		        				break;
							case DecafScannerTokenTypes.TK_void:
		        				type = " SEM RETORNO";
		        				break;
							case DecafScannerTokenTypes.TK_static:
		        				type = " STATIC";
		        				break;
							case DecafScannerTokenTypes.TK_main:
		        				type = " METODO";
		        				break;
							case DecafScannerTokenTypes.TK_String:
		        				type = " STRING";
		        				break;
							case DecafScannerTokenTypes.TK_args:
		        				type = " ARGS";
		        				break;
							case DecafScannerTokenTypes.ADDOP:
		        				type = " ADDOP";
		        				break;
							case DecafScannerTokenTypes.MULTOP:
		        				type = " MULTOP";
		        				break;
							case DecafScannerTokenTypes.OP_LOGICO:
		        				type = " OPERADOR LOGICO";
		        				break;
							case DecafScannerTokenTypes.OP_RELACIONAL:
		        				type = " OPERADOR RELACIONAL";
		        				break;
							case DecafScannerTokenTypes.OP_ATRIBUICAO:
		        				type = " OPERADOR DE ATRIBUICAO";
		        				break;
							case DecafScannerTokenTypes.ATRIBUICAO:
		        				type = " OPERADOR DE ATRIBUICAO";
		        				break;	
							case DecafScannerTokenTypes.PONTO:
		        				type = " PONTO";
		        				break;
							case DecafScannerTokenTypes.PAR_ESQ:
		        				type = " PARENTESES_ESQUERDA";
		        				break;
							case DecafScannerTokenTypes.PAR_DIR:
		        				type = " PARENTESES DIREITA";
		        				break;
							case DecafScannerTokenTypes.CHA_ESQ:
		        				type = " CHAVES_ESQUERDA";
		        				break;
							case DecafScannerTokenTypes.CHA_DIR:
		        				type = " CHAVES-DIREITA";
		        				break;
							case DecafScannerTokenTypes.CO_ESQ:
		        				type = " COLCHETES ESQUERDA";
		        				break;
							case DecafScannerTokenTypes.CO_DIR:
		        				type = " COLCHETES DIREITA";
		        				break;
							case DecafScannerTokenTypes.FIM_SENT:
		        				type = " FINAL DE SENTENCA";
		        				break;
		        			}
		        			System.out.println (token.getLine() + type + " " + text);
		        		}
		        		done = true;
        			} catch(Exception e) {
        	        	// print the error:
        	            System.out.println(CLI.infile+" "+e);
        	            lexer.consume ();
        	        }
        		}
        	}
        	else if (CLI.target == CLI.PARSE || CLI.target == CLI.DEFAULT)
        	{
        		DecafScanner lexer = new DecafScanner(new DataInputStream(inputStream));
        		DecafParser parser = new DecafParser (lexer);
                parser.program();
        	}
        	
        } catch(Exception e) {
        	// print the error:
            System.out.println(CLI.infile+" "+e);
        }
    }
}

