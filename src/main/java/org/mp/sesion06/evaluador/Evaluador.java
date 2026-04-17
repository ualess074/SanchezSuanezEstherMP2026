package org.mp.sesion06.evaluador;

import org.mp.sesion05.pilas.Stack;
import org.mp.sesion05.colas.Queue;

public class Evaluador {

    private Stack<Integer> pila;
    private Queue<String> cola;

    public Evaluador(Stack<Integer> pila, Queue<String> cola) {
        this.pila = pila;
        this.cola = cola;
    }

    public String[] eliminarBlancos(String expresion) {
        if (expresion == null || expresion.trim().isEmpty()) {
            return new String[]{};
        }

        return expresion
                .replaceAll("([+\\-*/])", " $1 ") 
                .trim()
                .split("\\s+"); 
    }

    
    public void procesarUnOperador(char op, Stack<Integer> pila) throws ExpresionMalFormadaException {

        if (pila.getSize() < 2) {
            throw new ExpresionMalFormadaException("Faltan operandos");
        }

        int b = pila.pop();
        int a = pila.pop();

        int resultado;

        switch (op) {
            case '+':
                resultado = a + b;
                break;
            case '-':
                resultado = a - b;
                break;
            case '*':
                resultado = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("División por cero");
                }
                resultado = a / b;
                break;
            default:
                throw new ExpresionMalFormadaException("Operador inválido");
        }

        pila.push(resultado);
    }

    public int evaluarExpresion(String expresion) throws ExpresionMalFormadaException {

        if (expresion == null || expresion.trim().isEmpty()) {
            throw new ExpresionMalFormadaException("Expresión vacía");
        }

        
        while (pila.getSize() > 0) {
            pila.pop();
        }

        String[] tokens = eliminarBlancos(expresion);

        boolean hayOperador = false;

        for (String token : tokens) {

            if (token.matches("-?\\d+")) {
                pila.push(Integer.parseInt(token));

            } else if (token.length() == 1 && "+-*/".contains(token)) {
                hayOperador = true;
                procesarUnOperador(token.charAt(0), pila);

            } else {
                throw new ExpresionMalFormadaException("Token inválido: " + token);
            }
        }

        
        if (!hayOperador) {
            StringBuilder sb = new StringBuilder();

            while (pila.getSize() > 0) {
                sb.insert(0, pila.pop()); 
            }

            return Integer.parseInt(sb.toString());
        }

        if (pila.getSize() != 1) {
            throw new ExpresionMalFormadaException("Expresión mal formada");
        }

        return pila.pop();
    }
}
