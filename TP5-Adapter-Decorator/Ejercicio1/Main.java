
public class Main {

	public static void main(String[] args) {
		MotorComun motorComun = new MotorComun();
		MotorAdapter motorElectrico = new MotorAdapter(new MotorElectrico());
		MotorEconomico motorEconomico = new MotorEconomico();
		
		motorComun.arrancar();
		motorComun.acelerar();
		motorComun.apagar();
		
		motorElectrico.arrancar();
		motorElectrico.acelerar();
		motorElectrico.apagar();
		
		motorEconomico.arrancar();
		motorEconomico.acelerar();
		motorEconomico.apagar();

	}

}
