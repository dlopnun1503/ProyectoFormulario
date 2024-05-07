package com.es.proyectoformulario.ui.panels;


import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author David Lopez
 */
public class PanelLogin extends JPanel {
    JTextField user;
    JTextField pass;
    JButton bEnviar;
    private FrameLogin framePadre;
    private JButton botonAlta;

    ServiceUser serviceUser = new ServiceUser();

    MouseListener listenerMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if(serviceUser.checkUser(user.getText(), pass.getText())) {
                cargarPanelEnviar();
            } else {
                System.out.println("Pa tu casa");
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

    private MouseListener mouseListenerAlta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelAlta();
        }
    };

    public PanelLogin(FrameLogin framePadre) {

        this.framePadre = framePadre;

        this.setBackground(new Color(174, 139, 225));
        this.setLayout(null);

        JLabel usuario = new JLabel("Usuario: ");
        usuario.setLocation(new Point(200,135));
        usuario.setSize(new Dimension(152,32));
        // usuario.setFont(new Font("Consolas", Font.BOLD, 22));
        this.add(usuario);

        user = new JTextField("");
        user.setLocation(new Point(260,135));
        user.setSize(new Dimension(152,32));
        this.add(user);

        JLabel passwd = new JLabel("Passwd: ");
        passwd.setLocation(new Point(200,200));
        passwd.setSize(new Dimension(152,32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(260,200));
        pass.setSize(new Dimension(152,32));
        this.add(pass);

        bEnviar = new JButton("Login");
        bEnviar.setLocation(new Point(150,321));
        bEnviar.setSize(new Dimension(152,32));
        this.add(bEnviar);
        bEnviar.addMouseListener(listenerMouse);


        botonAlta = new JButton("Darse de alta");
        botonAlta.setLocation(new Point(350, 321));
        botonAlta.setSize(new Dimension(152,32));
        this.add(botonAlta);
        botonAlta.addMouseListener(mouseListenerAlta);
    }


    private void cargarPanelAlta(){
        // Eliminamos this panelLogin....este....no otro
        framePadre.remove(this);

        // Añadimos un panelAlta al frame
        PanelAlta panelAlta = new PanelAlta(framePadre);
        framePadre.add(panelAlta);

        // Ultimo: Repintar el frame
        framePadre.repaint();
        framePadre.revalidate();
    }


    private void cargarPanelEnviar(){
        // Eliminamos this panelLogin....este....no otro
        framePadre.remove(this);

        // Añadimos un panelAlta al frame
        PanelOpciones panelOpciones = new PanelOpciones(framePadre);
        framePadre.add(panelOpciones);

        // Ultimo: Repintar el frame
        framePadre.repaint();
        framePadre.revalidate();
    }

}
