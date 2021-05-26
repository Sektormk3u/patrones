
public class MotorComun implements Motor{

	@Override
	public void arrancar() {
		System.out.println("Arrancando motor comun");
		
	}

	@Override
	public void acelerar() {
		System.out.println("Acelerando motor comun");
		
	}

	@Override
	public void apagar() {
		System.out.println("Apagando motor comun");
		
	}

}
