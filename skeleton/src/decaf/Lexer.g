header {package decaf;}

options 
{
  mangleLiteralPrefix = "TK_";
  language="Java";
}

class DecafScanner extends Lexer;
options 
{
  k=2;
}

tokens 
{
  "class";
  "package";
  "protected";
  "import";
  "extends";
  "private";
  "if";
  "else";
  "for";
  "do";
  "while";
  "int";
  "double";
  "float";
  "return";
  "void";
  "static";
  "main";
  "String";
  "args";
}

ATRIBUICAO options { paraphrase = "an identifier"; } : "=";

ID options { paraphrase = "an identifier"; } : 
  ('a'..'z' | 'A'..'Z')+;
  
NUMERO options { paraphrase = "an number"; } : 
  ('0'..'9')+;
  
WS_ : (' ' | '\n' | '\t' | '\r' {newline();}) {_ttype = Token.SKIP; };

SL_COMMENT : "//" (~'\n')* '\n' {_ttype = Token.SKIP; newline (); };

CHAR : '\'' (ESC|~'\'') '\'';
STRING : '"' (ESC|~'"')* '"';

protected
ESC :  '\\' ('n'|'"');
ADDOP : '+' | '-' ;
MULTOP : '*' | '/';
OP_LOGICO : "&&" | "||" | '!' | '&' | '|' ;
OP_RELACIONAL : '>' | '<' | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ;
OP_ATRIBUICAO : "+=" | "-="  | "*=" | "/=" | "%=" | "++" | "--" ;
PONTO : '.';
PAR_ESQ : '(';
PAR_DIR : ')';
CHA_ESQ : '{';
CHA_DIR : '}';
CO_ESQ : '[';
CO_DIR : ']';
FIM_SENT : ';';


