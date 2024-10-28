// Clase CuadradoVista
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CuadradoVista extends JFrame {
    private final CuadradoControl controlador;

    public CuadradoVista(CuadradoControl controlador) {
        this.controlador = controlador;
        setTitle("Cuadrado");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean relleno = e.getButton() == MouseEvent.BUTTON3;
                controlador.agregarCuadrado(e.getX(), e.getY(), relleno);
                repaint(); // solicita repintar la ventana
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'n' || e.getKeyChar() == 'v' || e.getKeyChar() == 'a' || e.getKeyChar() == 'r') {
                    controlador.cambiarColorCuadrado(e.getKeyChar()); // cambia el color según la tecla presionada
                    repaint(); // repinta para reflejar el cambio de color
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) { // Detecta la barra espaciadora
                    controlador.limpiarCuadrados(); // Limpia todos los cuadrados
                    repaint(); // repinta para reflejar los cambios
                }
            }
        });

        setFocusable(true); // permite que el JFrame reciba eventos de teclado
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g); // limpia el panel antes de dibujar
        controlador.dibujarCuadrados(g); // pide al controlador que dibuje los cuadrados
    }
}
