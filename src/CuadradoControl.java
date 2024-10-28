// Clase CuadradoControl
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CuadradoControl {
    private final List<Cuadrado> cuadrados = new ArrayList<>();
    private final Random random = new Random();
    private Color colorActual = Color.RED; // Color inicial
    private final CuadradoVista vista;

    public CuadradoControl() {
        vista = new CuadradoVista(this); // inicializa la vista
        vista.setVisible(true); // muestra la ventana
    }

    public void agregarCuadrado(int x, int y, boolean relleno) {
        int lado = random.nextInt(100) + 20; // lado aleatorio entre 20 y 119
        Cuadrado cuadrado = new Cuadrado(lado, x, y, relleno, colorActual);
        cuadrados.add(cuadrado);
    }

    public void cambiarColorCuadrado(char tecla) {
        switch (Character.toLowerCase(tecla)) {
            case 'n': colorActual = Color.BLACK; break;
            case 'v': colorActual = Color.GREEN; break;
            case 'a': colorActual = Color.BLUE; break;
            case 'r': colorActual = Color.YELLOW; break;
            default: colorActual = Color.RED; // color por defecto
        }
        for (Cuadrado cuadrado : cuadrados) {
            cuadrado.setColor(colorActual); // actualiza el color de todos los cuadrados
        }
    }

    public void limpiarCuadrados() {
        cuadrados.clear(); // Borra todos los cuadrados de la lista
    }

    public void dibujarCuadrados(Graphics g) {
        for (Cuadrado cuadrado : cuadrados) {
            cuadrado.dibujar(g,colorActual); // dibuja cada cuadrado de la lista
        }
    }

    public static void main(String[] args) {
        new CuadradoControl();
    }
}
