import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilaGUI {
    private JPanel pGeneral;
    private JTextField inputField;
    private JTextArea textArea1;
    private JButton apilarButton;
    private JButton desapilarButton;

    private Pila pila=new Pila();;

    public PilaGUI() {
        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    // Intentar convertir la entrada en un número entero
                    int valor = Integer.parseInt(input);
                    pila.apilar(valor,textArea1);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    // Mostrar mensaje si la entrada no es un número válido
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }

        });
        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pila.desapilar(textArea1);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PilaGUI");
        frame.setContentPane(new PilaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
