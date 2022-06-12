
public class CalculaEleitores {

	public static void main(String[] args) {
		System.out.println("Caluladora de votos\n");
		
		Calculadora calculadora = new Calculadora();
		calculadora.setValidos(800);
		calculadora.setBrancos(150);
		calculadora.setNulos(50);
		
		System.out.println("Percentuais");
		System.out.println("Válidos: "+calculadora.getPercentualValidos()+"%");
		System.out.println("Brancos: "+calculadora.getPercentualBrancos()+"%");
		System.out.println("Nulos: "+calculadora.getPercentualNulos()+"%");
	}
}
