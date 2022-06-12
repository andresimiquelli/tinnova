import java.util.Scanner;

public class CalculaFatorial {

	public static void main(String[] args) {
		
		int value = 0;
		
		System.out.println("Calcula fatorial\n");

		Scanner scanner = new Scanner(System.in);
		
		do {			
			System.out.print("Informe um número maior que zero: ");
			value = scanner.nextInt();
		}while(value <= 0);
		
		scanner.close();
		
		int fat = fatorial(value);
		System.out.println("Fatorial: "+fat);
		
	}
	
	public static int fatorial(int value) {
		if(value > 1)
			return value* fatorial(value-1);
		
		return 1;
	}
}
