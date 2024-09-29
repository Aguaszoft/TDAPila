import javax.swing.*;

public class Pila {
    private Nodo cima;
    private int tamano;



    // Constructor de la pila
    public Pila() {
        cima = null;
        tamano = 0;
    }

    // Método para apilar (push) un valor entero
    public void apilar(int dato,JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamano++;
        actualizarTextArea(textArea);
    }

    // Método para desapilar (pop) un valor entero
    public int desapilar(JTextArea textArea) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
            return -1;
        }
        int dato = cima.dato;
        cima = cima.siguiente;
        tamano--;
        actualizarTextArea(textArea);
        return dato;
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return cima == null;
    }

    // Método para mostrar la pila en el JTextArea
    public void mostrarPila(JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("La pila está vacía.");
        } else {
            StringBuilder pilaStr = new StringBuilder();
            Nodo actual = cima;
            while (actual != null) {
                pilaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(pilaStr.toString());
        }
    }

    // Método para actualizar el JTextArea cada vez que cambia la pila
    private void actualizarTextArea(JTextArea textArea) {
        mostrarPila(textArea);
    }

}
