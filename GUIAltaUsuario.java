// VISTA
public class GUIAltaUsuario extends JFrame {
    public GUIAltaUsuario() {
        this.setTitle("Alta usuario");
        JPanel panel = new JPanel();
        JLabel lNombre = new JLabel("Nombre:");
        final JTextField tNombre = new JTextField(20);
        JLabel lEMail = new JLabel("e-mail:");
        final JTextField tEMail = new JTextField(20);
        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        this.panel.add(lNombre);
        this.panel.add(tNombre);
        this.panel.add(lEMail);
        this.panel.add(tEmail);
        this.panel.add(aceptar);
        this.panel.add(cancelar);
        this.getContentPane().add(panel);
        this.pack();
    }
    aceptar.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            String nombre= tNombre.getText();
            String eMail= tEMail.getText();
            TUsuario tU= new TUsuario(nombre , eMail);
            Controlador.getInstancia().accion(Eventos.ALTA_USUARIO, tU);
        }
    });
    //……………………………
}

public class Evento {
    public static final int ALTA_USUARIO = 101;
    public static final int BAJA_USUARIO = 102;
    public static final int MOSTRAR_USUARIO = 103;
    //...
    public static final int RES_ALTA_USUARIO_OK = 401;
    public static final int RES_ALTA_USUARIO_KO = 402;
    //...
}

// CONTROLADOR
public class Controlador {
    private SAUsuario saUsuario;
    private IGUI gui;
    // Implementación naif de una tabla del controlador acorde al Singleton, debería estar en la subclase
    public void accion(int evento, Object datos) {
        switch(evento) {
            case Evento.ALTA_USUARIO:
                TUsuario tUsuario = (TUsuario) datos;
                // MODELO
                int res = saUsuario.alta(tUsuario);
                if (res > 0) {
                    gui.actualizar(Evento.RES_ALTA_USUARIO_OK, new Integer(res));
                }
                else {
                    gui.actualizar(Evento.RES_ALTA_USUARIO_KO, null);
                }
            break;
            case Evento.BAJA_USUARIO:
                //...
            break;
            //...
        }
    }
}

public interface IGUI {
    void actualizar(int evento, Object datos);
}

public class GUIBiblioteca extends JFrame implements IGUI{
    private static GUIBiblioteca guiBiblioteca;
    private IGUIUsuario guiUsuario;
    private IGUIPublicacion guiPublicacion;
    private IGUIPrestamo guiPrestamo;
    private Controlador controlador;

    public void actualizar(int evento, Object datos) {
        switch (evento) {
            case Evento.MOSTRAR_GUI_BIBLIOTECA: setVisible(true); break;
            case Evento.OCULTAR_GUI_BIBLIOTECA: setVisible(false); break; 
            //...
            case EventoGUI.RES_ALTA_USUARIO_OK:
                Integer id = (Integer) datos;
                JOptionPane.showMessageDialog(null,"Usuario creado con ID: "+id.intValue());setVisible(true);
                break;
            case EventoGUI.RES_ALTA_USUARIO_KO:
                JOptionPane.showMessageDialog(null, "No se pudo crear al usuario");
                setVisible(true);
                break;
            //...
        }
    }
}