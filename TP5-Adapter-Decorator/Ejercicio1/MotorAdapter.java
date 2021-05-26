
public class MotorAdapter implements Motor {

	private MotorElectrico motorElectrico;

	public MotorAdapter(MotorElectrico motor) {
		this.motorElectrico = motor;
	}

	@Override
	public void arrancar() {
		motorElectrico.conectar();
		motorElectrico.activar();
	}

	@Override
	public void acelerar() {
		motorElectrico.moverMasRapido();

	}

	@Override
	public void apagar() {
		motorElectrico.detener();
		motorElectrico.desconectar();

	}

}
