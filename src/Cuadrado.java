import java.awt.*;

public class Cuadrado {
    private int lado;
    private int x;
    private int y;
    private final boolean relleno;
    private Color color;

    public Cuadrado(int lado, int x, int y,Color color) {
        this.lado = lado;
        this.x = x;
        this.y = y;
        this.relleno = false;
        this.color = color;
    }

    public Cuadrado(int lado, int x, int y, boolean relleno,Color color) {
        this.lado = lado;
        this.x = x;
        this.y = y;
        this.relleno = relleno;
        this.color = color;
    }

    public void dibujar(Graphics g,Color c) {
        if (relleno) {
            g.setColor(c);//color del relleno
            g.fillRect(x, y, lado, lado); //rellena el cuadrado
        }
        g.setColor(Color.BLACK); //color del cuadrado
        g.drawRect(x, y, lado, lado); //dibuja el contorno del cuadrado
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
