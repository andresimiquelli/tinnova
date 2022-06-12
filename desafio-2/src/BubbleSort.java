
public class BubbleSort {

	public static void main(String[] args) {
		
		int vetor[] = {5,3,2,4,7,1,0,6};
		
		System.out.print("Não ordenado: ");
		exibeVetor(vetor);
		
		vetor = sort(vetor);
		
		System.out.print("Ordenado: ");
		exibeVetor(vetor);
		
		
	}
	
	public static void exibeVetor(int[] vetor) {
		System.out.print("{");
		for(int i = 0; i < vetor.length; i++) {
			if(i > 0)
				System.out.print(",");
			
			System.out.print(""+vetor[i]);
		}
		System.out.print("}\n");
	}
	
	public static int[] sort(int[] vetor) {
		for(int i = 0; i < vetor.length; i++) {
			boolean alterado = false;
			
			for(int ii = 0; ii < vetor.length-1; ii++) {
				if(vetor[ii] > vetor[ii+1]) {
					int val = vetor[ii];
					vetor[ii] = vetor[ii+1];
					vetor[ii+1] = val;
					alterado = true;
				}
			}
			
			if(!alterado)
				break;
		}
		
		return vetor;
	}
}
