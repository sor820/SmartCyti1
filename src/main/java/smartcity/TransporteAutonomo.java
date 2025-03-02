package smartcity;

public class TransporteAutonomo extends Vehiculo {

    public String encender() {
        System.out.println("Transporte autónomo encendido");
        setEstado(ENCENDIDO);
        setVelocidad(0);
        return "Transporte publico autónomo encendido";
    }

    public String apagar() {
        System.out.println("Transporte autónomo apagado");
        setEstado(APAGADO);
        setVelocidad(0);
        return "Transporte publico autónomo apagado";
    }


}
