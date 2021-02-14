package productorConsumidor;

public class Productor implements Runnable{
	
	private Monitor numero = null;
	private int veces = 0;
	
	public Productor(Monitor numero, int veces) {
		this.numero = numero;
		this.veces = veces;
	}
	
	@Override
	public void run() {
		int cont = 0;
		while (cont < veces) {
			if (numero.addNumber(cont)) {
				cont++;
			}
		}
		numero.showListNumbers();
	}

}
