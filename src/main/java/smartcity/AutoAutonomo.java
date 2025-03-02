package smartcity;

public class AutoAutonomo extends Vehiculo {
    public boolean pilotoAutomatico;

    public void setPilotoAutomatico(boolean pilotoAutomatico) {
        System.out.println("Piloto automático: " + pilotoAutomatico);
        this.pilotoAutomatico = pilotoAutomatico;
        if (pilotoAutomatico) {
            setEstado(MANEJO_MANUAL);
        } else {
            setEstado(EN_MOVIMIENTO);
        }
    }

    public String encender() {
        System.out.println("Auto encendido");
        setVelocidad(0);
        setEstado(ENCENDIDO);
        return "Auto encendido";
    }

    public String apagar() {
        System.out.println("Auto apagado");
        setEstado(APAGADO);
        setVelocidad(0);
        return "Auto apagado";
    }
}
