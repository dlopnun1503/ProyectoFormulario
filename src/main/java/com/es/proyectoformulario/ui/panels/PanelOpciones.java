package com.es.proyectoformulario.ui.panels;

import com.es.proyectoformulario.ui.frames.FrameLogin;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelOpciones extends JPanel {

    private FrameLogin framePadre;
    private JButton alta;
    private JButton baja;
    private JButton modificacion;
    private JButton consulta;
    private JButton volver;

    private MouseListener mouseListenerAlta = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelAlta();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(151, 174, 145));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(192, 221, 184));
        }
    };

    private MouseListener mouseListenerBaja = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(191, 106, 106));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(234, 132, 132));
        }
    };

    private MouseListener mouseListenerMod = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(161, 137, 75));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(216, 185, 105));
        }
    };


    private MouseListener mouseListenerCon = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelConsulta();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(86, 150, 186));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(new Color(105, 176, 216));
        }
    };

    private MouseListener mouseListenerVolver = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelVolver();
        }
    };
    private MouseListener mouseListenerModificar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelModificar();
        }
    };
    private MouseListener mouseListenerBja = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            cargarPanelBaja();
        }
    };


    public PanelOpciones(FrameLogin framePadre){
        this.framePadre = framePadre;

        this.setBackground(new Color(223, 220, 220));
        this.setLayout(null);

        alta = new JButton("Alta");
        alta.setBackground(new Color(192, 221, 184));
        alta.setLocation(new Point(225,100));
        alta.setSize(new Dimension(152,32));
        alta.addMouseListener(mouseListenerAlta);
        this.add(alta);

        baja = new JButton("Baja");
        baja.setBackground(new Color(234, 132, 132));
        baja.setLocation(new Point(225,200));
        baja.setSize(new Dimension(152,32));
        baja.addMouseListener(mouseListenerBaja);
        baja.addMouseListener(mouseListenerBja);
        this.add(baja);

        modificacion = new JButton("Modificacion");
        modificacion.setBackground(new Color(216, 185, 105));
        modificacion.setLocation(new Point(225,300));
        modificacion.setSize(new Dimension(152,32));
        modificacion.addMouseListener(mouseListenerMod);
        modificacion.addMouseListener(mouseListenerModificar);
        this.add(modificacion);

        consulta = new JButton("Consulta");
        consulta.setBackground(new Color(105, 176, 216));
        consulta.setLocation(new Point(225,400));
        consulta.setSize(new Dimension(152,32));
        consulta.addMouseListener(mouseListenerCon);
        this.add(consulta);


        volver = new JButton("Volver");
        volver.setLocation(new Point(20,500));
        volver.setSize(new Dimension(152,32));
        volver.addMouseListener(mouseListenerVolver);
        this.add(volver);

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

    private void cargarPanelConsulta(){
        // Eliminamos this panelLogin....este....no otro
        framePadre.remove(this);

        // Añadimos un panelAlta al frame
        PanelConsulta panelConsulta = new PanelConsulta(framePadre);
        framePadre.add(panelConsulta);

        // Ultimo: Repintar el frame
        framePadre.repaint();
        framePadre.revalidate();
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


    private void cargarPanelModificar(){
        // Eliminamos this panelLogin....este....no otro
        framePadre.remove(this);

        // Añadimos un panelAlta al frame
        PanelModificar panelModificar = new PanelModificar(framePadre);
        framePadre.add(panelModificar);

        // Ultimo: Repintar el frame
        framePadre.repaint();
        framePadre.revalidate();
    }

    private void cargarPanelBaja(){
        // Eliminamos this panelLogin....este....no otro
        framePadre.remove(this);

        // Añadimos un panelAlta al frame
        PanelBaja panelBaja = new PanelBaja(framePadre);
        framePadre.add(panelBaja);

        // Ultimo: Repintar el frame
        framePadre.repaint();
        framePadre.revalidate();
    }

}
