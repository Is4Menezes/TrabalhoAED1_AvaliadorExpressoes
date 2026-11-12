package Trabalho2AED;

public class AvaliadorPosFixa {
    public double avaliar(Fila <Character> posfixa){
        Pilha<Double> pilha = new Pilha<Double>();
        while(!posfixa.isVazia()){
            char car = posfixa.desenfileirar();
            if(car >= '0' && car <= '9'){
                pilha.push((double) (car - '0'));
            }else{
                double b = pilha.pop(); // operando da direita
                double a = pilha.pop(); // operando da esquerda
                pilha.push(calcular(a,b,car));
            }
        }
        return pilha.pop();
    }

    private double calcular(double a, double b, char operador){
        if(operador == '+'){
            return a + b;
        }else if(operador == '-'){
            return a - b;
        }else if (operador == '*'){
            return a * b;
        }else if (operador == '/'){
            if(b == 0){
                throw new ArithmeticException("Erro: divisão por zero");
            }
            return a / b;
        }else if(operador == '^'){
            return Math.pow(a, b);
        }
        throw new IllegalArgumentException("Operador inválido: " + operador);
    }
}
