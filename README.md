=====================================================================
 AVALIADOR DE EXPRESSÕES MATEMÁTICAS
 CEFET-MG - Campus Timóteo | Lab. AED I | Prof. Luciano Moreira
 Trabalho 2
 Integrantes: Isabella Senra Menezes e João Vitor Alves Silva
=====================================================================

1. O QUE O PROGRAMA FAZ
-----------------------
Lê uma expressão matemática na notação infixa (a usual, como
2 + 3 * 4), verifica se ela é sintaticamente válida, converte para a
notação pos-fixa (notação polonesa inversa) e calcula o resultado.

Exemplo:
    Entrada:  3+4*5
    Pos-fixa: 345*+
    Resultado: 23,00


2. REQUISITOS
-------------
- JDK (Java Development Kit) versão 17 ou superior.
- Não é necessária nenhuma biblioteca externa.
- O programa não usa estruturas prontas do Java (Stack, ArrayList,
  LinkedList etc.): Pilha, Fila e Celula foram implementadas pelo grupo.


3. ARQUIVOS DO PROGRAMA (pacote Trabalho2AED)
---------------------------------------------
Celula.java            Nó de lista encadeada (genérico).
Pilha.java             Pilha encadeada (genérica).
Fila.java              Fila encadeada com célula-cabeca (genérica).
ValidadorExpressao.java  Verifica a sintaxe da expressão infixa.
ConversorPosFixa.java  Converte infixa para pós-fixa.
AvaliadorPosFixa.java  Avalia a expressão pós-fixa.
Main.java              Menu em console (classe principal).


4. COMO EXECUTAR
----------------

4.1 Pelo Eclipse
  1. Importe o projeto: File > Import > General > Existing Projects
     into Workspace, e selecione a pasta do projeto.
  2. Abra a classe Main (pacote Trabalho2AED).
  3. Clique com o botão direito em Main.java > Run As > Java
     Application.
  4. Use o console do Eclipse para interagir com o programa.

4.2 Pelo terminal (linha de comando)
  1. Abra o terminal na pasta "src" do projeto (a pasta que contém a
     pasta Trabalho2AED).
  2. Compile:
         javac Trabalho2AED/*.java
  3. Execute:
         java Trabalho2AED.Main


5. COMO USAR
------------
Ao iniciar, o programa mostra um menu:

    Deseja:
    1 - Avaliar uma expressão infixa
    2 - Sair do programa

- Digite 1 e pressione Enter para avaliar uma expressão. Em seguida,
  digite a expressão e pressione Enter.
- O programa mostra a expressao em pós-fixa e o resultado com duas
  casas decimais, e volta ao menu.
- Digite 2 e pressione Enter para encerrar.
- Digite apenas números (1 ou 2) no menu. Digitar letras no menu
  encerra o programa com erro.

Exemplo de uso:

    Deseja:
    1 - Avaliar uma expressao infixa
    2 - Sair do programa
    1
    Digite a expressao infixa: (3+4)*5
    Expressao convertida para posfixa: 34+5* = 35,00


6. REGRAS PARA DIGITAR A EXPRESSÃO
----------------------------------
- Números de UM único algarismo (0 a 9). Exemplo: 7 é válido, 12 não.
- Operadores aceitos:
      +   adição
      -   subtração
      *   multiplicação
      /   divisão (divisão real: 7/2 = 3,5)
      ^   exponenciação (3^2 = 9)
- Parênteses ( e ) para alterar a precedência.
- Espaços são ignorados: "2 + 5 * 8" e "2+5*8" são equivalentes.
- Precedência (da maior para a menor): ^ ; * e / ; + e -
- Operadores de mesma precedencia: da esquerda para a direita
  (8-3-2 = 3), exceto ^, que é da direita para a esquerda
  (2^3^2 = 2^9 = 512).
- Sinal unário NÃO é aceito: -3+4 e inválida. Use 0-3+4.


7. MENSAGENS DE ERRO
--------------------
Expressão inválida!
    A expressão tem erro de sintaxe (parênteses sem par, operador
    seguido de operador, número com mais de um algarismo, caractere
    desconhecido, expressão vazia etc.).

Erro: divisão por zero
    A expressão é válida, mas divide por zero. Exemplo: 5/(3-3).

Após qualquer erro, o programa volta ao menu.


8. EXEMPLOS PARA TESTAR
-----------------------
    Expressão                    Resultado esperado
    3+4*5                        23,00
    (3+4)*5                      35,00
    8-3-2                        3,00
    2^3^2                        512,00
    7/2*2                        7,00
    2+3*(4-1)^2/3                11,00
    ((1+2)*3-(4-5))^(1+1)        100,00
    2 + 5 * 8 / ( 4 + 3 )        7,71
    2^3*4-5+6/7/(8+9)            27,05
    ( 3 ( + 5 ) )                Expressao inválida!
    5/(3-3)                      Erro: divisão por zero



9. LIMITAÇÕES CONHECIDAS
------------------------
- Apenas números de um algarismo e sem sinal.
- Os resultados usam a vírgula como separador decimal quando o
  computador está configurado em português do Brasil.

Mais detalhes no documento de Especificação de Requisitos e
Arquitetura do Programa.
