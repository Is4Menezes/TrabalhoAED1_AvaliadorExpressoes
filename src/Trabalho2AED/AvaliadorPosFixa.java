package Trabalho2AED;

public class AvaliadorPosFixa {
    public int avaliar(Fila <Character> posfixa){
        Pilha<Integer> pilha = new Pilha<Integer>();
        while(!posfixa.isVazia()){
            char car = posfixa.desenfileirar();
            if(car >= '0' && car <= '9'){
                pilha.push(car - '0');
            }else{
                int b = pilha.pop(); // operando da direita
                int a = pilha.pop(); // operando da esquerda
                pilha.push(calcular(a,b,car));
            }
        }
        return pilha.pop();
    }

    private int calcular(int a,int b,char operador){
        if(operador == '+'){
            return a + b;
        }else if(operador == '-'){
            return a - b;
        }else if (operador == '*'){
            return a * b;
        }else if (operador == '/'){
            if(b == 0){
                throw new ArithmeticException("Divisão por zero");
            }
            return a / b;
        }else if(operador == '^'){
            return potencia(a,b);
        }
        throw new IllegalArgumentException("Operador inválido: " + operador);
    }

    private int potencia(int base,int exponencial ) {
        if(exponencial < 0){
            throw new ArithmeticException("Expoente negativo");
        }
        if(exponencial == 0) {
            return 1;
        }
        return base * potencia(base,exponencial - 1);
    }
}
