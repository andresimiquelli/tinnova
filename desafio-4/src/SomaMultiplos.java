import java.util.Scanner;

public class SomaMultiplos {

	public static void main(String[] args) {
		
		int value = 0;
		int soma = 0;
		
		System.out.println("Soma dos múltiplos de 3 e 5\n");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe um número para iniciar: ");
        value = scanner.nextInt();
        scanner.close();
        
        for(int i = value; i > 0; i--) {
        	
        	if(i%3 == 0) {
        		soma += i;
        	}else if(i%5 == 0) {
        		soma += i;
        	}
        	
        }
        
        System.out.println("A soma é: "+soma);
        
    }
	
}
