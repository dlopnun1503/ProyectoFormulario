package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.model.User;
import com.es.proyectoformulario.services.impl.ServiceUser;
import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelBaja extends JPanel {


    private FrameLogin framePadre;
    private JTextField idUser;
    private JTextField nombreUser;
    private JPasswordField pass;
    private JPasswordField pass1;
    private JCheckBox esAdmin;
    private JButton baja;
    private JTextField user;
    private JButton consultar;
    private JButton volver;
    private ServiceUser serviceUser = new ServiceUser();

    private MouseListener mouseListenerVolver = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelVolver();
        }
    };
    private MouseListener mouseListenerBaja = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            User usuarioEncontrado = serviceUser.getUser(user.getText());
            serviceUser.bajaUsuario(usuarioEncontrado);
            System.out.println("Usuario eliminado");
        }
    };

    private MouseListener mouseListenerConsultar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (serviceUser.userExists(user.getText())) {
                User usuarioEncontrado = serviceUser.getUser(user.getText());
                idUser.setText(usuarioEncontrado.getId());
                nombreUser.setText(usuarioEncontrado.getName());
                pass.setText(usuarioEncontrado.getPass());
                pass1.setText(usuarioEncontrado.getPass());
                if (usuarioEncontrado.isAdmin()){
                    esAdmin.setSelected(true);
                }else {
                    esAdmin.setSelected(false);
                }

            }
        }
    };


    public PanelBaja(FrameLogin framePadre){

        this.framePadre = framePadre;
        this.setLayout(null);
        this.setBackground(new Color(174, 139, 225));

        JLabel usuarioConsulta = new JLabel("Id usuario: ");
        usuarioConsulta.setLocation(new Point(150,30));
        usuarioConsulta.setSize(new Dimension(152,32));
        this.add(usuarioConsulta);


        user = new JTextField("");
        user.setLocation(new Point(220,30));
        user.setSize(new Dimension(152,32));
        this.add(user);

        consultar = new JButton("Consultar");
        consultar.setLocation(new Point(225,80));
        consultar.setBackground(new Color(105, 176, 216));
        consultar.setSize(new Dimension(152,32));
        consultar.addMouseListener(mouseListenerConsultar);
        this.add(consultar);


        JLabel nuevosDatos = new JLabel("NUEVOS DATOS");
        nuevosDatos.setLocation(new Point(225,110));
        nuevosDatos.setSize(new Dimension(152,100));
        nuevosDatos.setBackground(new Color(0, 0 ,0));
        this.add(nuevosDatos);

        JLabel usuario = new JLabel("Id usuario: ");
        usuario.setLocation(new Point(180,200));
        usuario.setSize(new Dimension(152,32));
        this.add(usuario);

        idUser = new JTextField("");
        idUser.setLocation(new Point(260,200));
        idUser.setEditable(false);
        idUser.setSize(new Dimension(152,32));
        idUser.setEditable(false);
        this.add(idUser);


        JLabel nombre = new JLabel("Nombre usuario: ");
        nombre.setLocation(new Point(150,250));
        nombre.setSize(new Dimension(152,32));
        this.add(nombre);

        nombreUser = new JTextField("");
        nombreUser.setLocation(new Point(260,250));
        nombreUser.setEditable(false);
        nombreUser.setSize(new Dimension(152,32));
        this.add(nombreUser);

        JLabel passwd = new JLabel("Passwd: ");
        passwd.setLocation(new Point(180,300));
        passwd.setSize(new Dimension(152,32));
        this.add(passwd);

        pass = new JPasswordField();
        pass.setLocation(new Point(260,300));
        pass.setEditable(false);
        pass.setSize(new Dimension(152,32));
        this.add(pass);

        JLabel passwd1 = new JLabel("Repita passwd: ");
        passwd1.setLocation(new Point(150,350));
        passwd1.setSize(new Dimension(152,32));
        this.add(passwd1);

        pass1 = new JPasswordField();
        pass1.setLocation(new Point(260,350));
        pass1.setSize(new Dimension(152,32));
        pass1.setEditable(false);
        this.add(pass1);

        JLabel admin = new JLabel("Is admin: ");
        admin.setLocation(new Point(180,400));
        admin.setSize(new Dimension(152,32));
        this.add(admin);

        esAdmin = new JCheckBox();
        esAdmin.setLocation(new Point(260,400));
        esAdmin.setSize(new Dimension(152,32));
        this.add(esAdmin);

        baja = new JButton("Baja");
        baja.setLocation(new Point(220,450));
        baja.setBackground(new Color(234, 132, 132));
        baja.setSize(new Dimension(152,32));
        baja.addMouseListener(mouseListenerBaja);
        this.add(baja);


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
