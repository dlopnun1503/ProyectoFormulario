package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.services.impl.GestionFicheroUser;
import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAlta extends JPanel {

    private FrameLogin framePadre;
    JTextField idUser;
    JTextField nombreUser;
    JPasswordField pass;
    JPasswordField pass1;
    JCheckBox esAdmin;
    JButton registrarse;
    private JButton volver;

    private MouseListener mouseListenerVolver = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelVolver();
        }
    };

    ServiceUser serviceUser = new ServiceUser();
    GestionFicheroUser gf = new GestionFicheroUser();

    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(!serviceUser.userExists(idUser.getText())) {
                if (pass.getText().equals(pass1.getText())) {
                    if (idUser.getText().length() > 0 && pass.getText().length() > 0 && nombreUser.getText().length() > 0) {
                        User usuario = new User(idUser.getText(), nombreUser.getText(), pass.getText(), esAdmin.isSelected());
                        serviceUser.altaUsuario(usuario);
                        System.out.println("Usuario registrado");
                        pass.setBackground(new Color(255, 255, 255));
                        pass1.setBackground(new Color(255, 255, 255));
                    }else {
                        System.out.println("Rellene campos vacios");
                    }
                }else {
                    pass.setBackground(new Color(255, 0, 0));
                    pass1.setBackground(new Color(255, 0, 0));
                    System.out.println("Las contrasenias no coinciden");
                }
            } else {
                System.out.println("Usuario en uso");
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(135, 206, 250)); // Fondo azul claro
            b.setBorder(new LineBorder(new Color(0, 115, 183), 3)); // Borde azul oscuro
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(102, 153, 204)); // Fondo azul medio
            b.setBorder(new LineBorder(new Color(135, 206, 250), 3)); // Borde azul claro
        }
    };
    public PanelAlta(FrameLogin framePadre){

        this.framePadre = framePadre;

        this.setBackground(new Color(174, 139, 225));
        this.setLayout(null);

        JLabel usuario = new JLabel("Usuario: ");
        usuario.setLocation(new Point(200,100));
        usuario.setSize(new Dimension(152,32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(usuario);

        idUser = new JTextField("");
        idUser.setLocation(new Point(260,100));
        idUser.setSize(new Dimension(152,32));
        this.add(idUser);


        JLabel nombre = new JLabel("Nombre: ");
        nombre.setLocation(new Point(200,150));
        nombre.setSize(new Dimension(152,32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(nombre);

        nombreUser = new JTextField("");
        nombreUser.setLocation(new Point(260,150));
        nombreUser.setSize(new Dimension(152,32));
        this.add(nombreUser);

        JLabel passwd = new JLabel("Passwd: ");
        passwd.setLocation(new Point(200,200));
        passwd.setSize(new Dimension(152,32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(260,200));
        pass.setSize(new Dimension(152,32));
        this.add(pass);

        JLabel passwd1 = new JLabel("Passwd: ");
        passwd1.setLocation(new Point(200,250));
        passwd1.setSize(new Dimension(152,32));
        this.add(passwd1);

        pass1 = new JPasswordField();
        pass1.setLocation(new Point(260,250));
        pass1.setSize(new Dimension(152,32));
        this.add(pass1);

        JLabel admin = new JLabel("Admin: ");
        admin.setLocation(new Point(200,300));
        admin.setSize(new Dimension(152,32));
        this.add(admin);

        esAdmin = new JCheckBox();
        esAdmin.setLocation(new Point(260,300));
        esAdmin.setSize(new Dimension(152,32));
        this.add(esAdmin);

        registrarse = new JButton("Registrarse");
        registrarse.setLocation(new Point(220,380));
        registrarse.setSize(new Dimension(152,32));
        this.add(registrarse);
        registrarse.addMouseListener(listenerMouse);

        volver = new JButton("Volver");
        volver.setLocation(new Point(20,500));
        volver.setSize(new Dimension(152,32));
        volver.addMouseListener(mouseListenerVolver);
        this.add(volver);
    }

    private void cargarPanelVolver(){
        // Eliminamos this panelLogin....este....no otro
        framePadre.remove(this);

        // Añadimos un panelAlta al frame
        PanelLogin panelLogin = new PanelLogin(framePadre);
        framePadre.add(panelLogin);

        // Ultimo: Repintar el frame
        framePadre.repaint();
        framePadre.revalidate();
    }
}
