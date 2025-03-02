import javax.swing.*;
import com.formdev.flatlaf.FlatDarculaLaf;
import smartcity.AutoAutonomo;
import smartcity.BicicletaElectrica;
import smartcity.TransporteAutonomo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JComboBox<String> tiposVehiculos;
    private JButton apagarButton;
    private JButton moverButton;
    private JButton mostrarSensorButton;
    private JPanel panelPrincipal;
    private JButton encenderButton;
    private JTextArea salida1;
    private JLabel salida;

    private AutoAutonomo auto;
    private BicicletaElectrica bici;
    private TransporteAutonomo bus;

    //**************************

    public Principal() {
        crearInstancias();
        inicializarForma();
        encenderButton.addActionListener(e -> TipoEncendido());
        apagarButton.addActionListener(e -> TipoApagado());
        moverButton.addActionListener(e -> moverVehiculo());
        mostrarSensorButton.addActionListener(e -> mostrarSensor());


        tiposVehiculos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                salida1.setText("" + tiposVehiculos.getSelectedItem());
            }
        });

    }

    private void crearInstancias() {
        auto = new AutoAutonomo();
        bici = new BicicletaElectrica();
        bus = new TransporteAutonomo();

    }

    public void TipoEncendido() {
        var tipoAuto = this.tiposVehiculos.getSelectedItem();
        if ("Auto Autonomo".equals(tipoAuto)) {
            salida1.append(auto.encender() + "\n");
        } else if ("Bicicleta Electrica".equals(tipoAuto)) {
            salida1.append(bici.encender() + "\n");
        } else if ("Transporte Público Autónomo".equals(tipoAuto)) {
            salida1.append(bus.encender() + "\n");
        }
    }


    public void TipoApagado() {
        var tipoAuto = this.tiposVehiculos.getSelectedItem();
        if ("Auto Autonomo".equals(tipoAuto)) {
            salida1.append(auto.apagar() + "\n");
        } else if ("Bicicleta Electrica".equals(tipoAuto)) {
            salida1.append(bici.apagar() + "\n");
        } else if ("Transporte Público Autónomo".equals(tipoAuto)) {
            salida1.append(bus.apagar() + "\n");
        }
    }

    //**************************************

    //**************************************
    public void mostrarSensor() {
        var tipoAuto = this.tiposVehiculos.getSelectedItem();
        if ("Auto Autonomo".equals(tipoAuto)) {
            salida1.append("Estado: " + auto.getEstado() + "\n");
            salida1.append("Nivel de batería: " + auto.getBateria() + "\n");
            salida1.append("Velocidad: " + auto.getVelocidad() + "\n");
            salida1.append("Encendido: " + (auto.isEncendido() ? "Sí" : "No") + "\n");
        } else if ("Bicicleta Electrica".equals(tipoAuto)) {
            salida1.append("Estado: " + bici.getEstado() + "\n");
            salida1.append("Nivel de batería: " + bici.getBateria() + "\n");
            salida1.append("Velocidad: " + bici.getVelocidad() + "\n");
            salida1.append("Encendido: " + (bici.isEncendido() ? "Sí" : "No") + "\n");
        } else if ("Transporte publico autonomo".equals(tipoAuto)) {
            salida1.append("Estado: " + bus.getEstado() + "\n");
            salida1.append("Nivel de batería: " + bus.getBateria() + "\n");
            salida1.append("Velocidad: " + bus.getVelocidad() + "\n");
            salida1.append("Encendido: " + (bus.isEncendido() ? "Sí" : "No") + "\n");
        }
    }

    public void moverVehiculo() {
        var tipoAuto = this.tiposVehiculos.getSelectedItem();
        if ("Auto Autonomo".equals(tipoAuto)) {
            if (auto.isEncendido()) {
                auto.mover();
                salida1.append("El Auto Autonomo se ha movido. Estado: " + auto.getEstado() + "\n");
                salida1.append("Nivel de batería: " + auto.getBateria() + "\n");
                salida1.append("Velocidad: " + auto.getVelocidad() + "\n");
            } else {
                salida1.append("El Auto Autonomo no está encendido.\n");
            }
        } else if ("Bicicleta Electrica".equals(tipoAuto)) {
            if (bici.isEncendido()) {
                bici.mover();
                salida1.append("La Bicicleta Electrica se ha movido. Estado: " + bici.getEstado() + "\n");
                salida1.append("Nivel de batería: " + bici.getBateria() + "\n");
                salida1.append("Velocidad: " + bici.getVelocidad() + "\n");
            } else {
                salida1.append("La Bicicleta Electrica no está encendida.\n");
            }
        } else if ("Transporte publico autonomo".equals(tipoAuto)) {
            if (bus.isEncendido()) {
                bus.mover();
                salida1.append("El Transporte publico autonomo se ha movido. Estado: " + bus.getEstado() + "\n");
                salida1.append("Nivel de batería: " + bus.getBateria() + "\n");
                salida1.append("Velocidad: " + bus.getVelocidad() + "\n");
            } else {
                salida1.append("El Transporte publico autonomo no está encendido.\n");
            }
        }
    }

    //**************************************


    private void inicializarForma() {
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(625, 450);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();//cambiar look and feell a modo oscuro
        Principal pr = new Principal();
        pr.setVisible(true);

    }


}
