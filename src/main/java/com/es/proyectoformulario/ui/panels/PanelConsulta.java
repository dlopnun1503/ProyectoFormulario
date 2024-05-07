package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelConsulta extends JPanel {

    private FrameLogin framePadre;
    private JButton volver;
    private JButton consultar;
    private JTextField user;
    private JTextArea area;
    private ServiceUser serviceUser = new ServiceUser();

    private MouseListener mouseListenerVolver = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelVolver();
        }
    };

    private MouseListener mouseListenerConsultar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (serviceUser.userExists(user.getText())){
                User usuarioEncontrado = serviceUser.getUser(user.getText());
                area.setText("ID:  " + usuarioEncontrado.getId()+ "\n"+ "\n"+ "Nombre:  " +usuarioEncontrado.getName()+ "\n"+ "\n"+ "Pass:  " +usuarioEncontrado.getPass()+"\n"+ "\n" + "Admin:  " +usuarioEncontrado.isAdmin());
            }
        }
    };
    public PanelConsulta(FrameLogin framePadre){
        this.framePadre = framePadre;
        this.setLayout(null);
        this.setBackground(new Color(174, 139, 225));


        consultar = new JButton("Consultar");
        consultar.setLocation(new Point(300,150));
        consultar.setBackground(new Color(105, 176, 216));
        consultar.setSize(new Dimension(152,32));
        consultar.addMouseListener(mouseListenerConsultar);
        this.add(consultar);

        user = new JTextField("");
        user.setLocation(new Point(100,150));
        user.setSize(new Dimension(152,32));
        this.add(user);

        area = new JTextArea();
        area.setLocation(new Point(150, 220));
        area.setSize(new Dimension(300, 200));
        this.add(area);

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
        PanelOpciones panelOpciones = new PanelOpciones(framePadre);
        framePadre.add(panelOpciones);

        // Ultimo: Repintar el frame
        framePadre.repaint();
        framePadre.revalidate();
    }


}
