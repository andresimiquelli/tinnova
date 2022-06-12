
public class Calculadora {

	private int validos = 0;
	private int brancos = 0;
	private int nulos = 0;
	
	public Calculadora() {}
	
	public Calculadora(int validos, int brancos, int nulos) {
		this.validos = validos;
		this.brancos = brancos;
		this.nulos = nulos;
	}

	public int getTotal() {
		return validos+brancos+nulos;
	}

	public int getValidos() {
		return validos;
	}

	public void setValidos(int validos) {
		this.validos = validos;
	}

	public int getBrancos() {
		return brancos;
	}

	public void setBrancos(int brancos) {
		this.brancos = brancos;
	}

	public int getNulos() {
		return nulos;
	}

	public void setNulos(int nulos) {
		this.nulos = nulos;
	}
	
	public float getPercentualValidos() {
		int total = getTotal();
		return validos*100/total;
	}
	
	public float getPercentualBrancos() {
		int total = getTotal();
		return brancos*100/total;
	}
	
	public float getPercentualNulos() {
		int total = getTotal();
		return nulos*100/total;
	}

	@Override
	public String toString() {
		return "Calculadora [validos=" + validos + ", brancos=" + brancos + ", nulos=" + nulos + ", total="
				+ getTotal() + "]";
	}
	
	
}
