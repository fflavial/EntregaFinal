# EntregaFinal

Essa é a parte final do Trabalho da disciplina de Construção de Compiladores das alunas Flávia Lessa de Aguiar e Fernanda Lessa de Aguiar do 6° semestre do Curso de Ciência da Computação no Uniceub

Usamos a ferramenta ANT
Diminuimos a gramatica, ficou bem menor comparada com a entrega do analisador sintatico, removendo ambiguidades e outros problemas. Não é uma gramatica completa de JAVA, mas tem o que é necessário.

O caminho da gramática é:  skeleton/src/decaf, que são os arquivos Lexer.g e Parser.g
O código de testes que usamos se encontra em skeleton/teste.txt

O código é praticamente o mesmo que o professor usou para avaliar o analisador sintático, porém, tiramos algumas coisas devido as alterações feitas na gramática.

#Passo a passo

Abra o cmd, entre na pasta skeleton e siga os seguintes passos

cd skeleton

ant

java -jar dist/Compiler.jar -target scan teste.txt

O programa ira mostrar a sequencia dos tokens e dos lexemas.
