header {package decaf;}

options
{
  mangleLiteralPrefix = "TK_";
  language="Java";
}

class DecafParser extends Parser;
options
{
  importVocab=DecafScanner;
  k=3;
  buildAST=true;
}

//import: TK_import ID (PONTO ID)?;
program:  (pacote)? TK_public TK_class ID  CHA_ESQ 
TK_public TK_static TK_void TK_main 
 PAR_ESQ  TK_String C0_ESQ CO_DIR TK_args PAR_DIR CHA_ESQ statement CHA_DIR CHA_DIR ; 

pacote : TK_package ID FIM_SENT;

statement: (nif|nfor|natribuicao|declaraVariavel|nwhile)* ;

declaraVariavel : palavra_reservada ID ATRIBUICAO NUMERO FIM_SENT;
operacaoComparacao : ID OP_RELACIONAL NUMERO;
operacaoCT : ID OP_ATRIBUICAO ;	   
palavra_reservada : TK_int | TK_float | TK_double;

// ex: for(int i=1;i<=10;i++)	   
nfor : TK_for PAR_ESQ  declaraVariavel operacaoComparacao FIM_SENT operacaoCT PAR_DIR CHA_ESQ statement CHA_DIR;	  
nelse : TK_else CHA_ESQ statement CHA_DIR;
nif : TK_if PAR_ESQ operacaoComparacao PAR_DIR CHA_ESQ statement CHA_DIR (nelse)?; 
natribuicao : ID OP_ATRIBUICAO expr FIM_SENT;
 
//if (i==10) { }

nwhile : TK_while  PAR_ESQ operacaoComparacao PAR_DIR CHA_ESQ statement CHA_DIR ;


// ex: public class Analisador {
//         public static void main ( String [] args ) { i=this;} }



expr : term (ADDOP expr)?;
term : parenteses (MULTOP term)?;

parenteses : numero_id | PAR_ESQ expr PAR_DIR;
numero_id : ID | NUMERO;