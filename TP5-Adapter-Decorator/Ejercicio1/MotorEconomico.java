
public class MotorEconomico implements Motor{

	@Override
	public void arrancar() {
		System.out.println("Arrancando motor economico");		
	}

	@Override
	public void acelerar() {
		System.out.println("Acelerando motor economico");
		
	}

	@Override
	public void apagar() {
		System.out.println("Apagando motor economico");
		
	}

}
