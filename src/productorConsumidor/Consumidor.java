package productorConsumidor;

public class Consumidor implements Runnable{
	
	private Monitor numero = null;
	private int veces = 0;
	
	public Consumidor(Monitor numero, int veces) {
		this.numero = numero;
		this.veces = veces;
	}

	
	@Override
	public void run() {
		int cont = 0;
		while (cont < veces) {
			if (numero.removeNumber()) {
				cont++;
			}
		}
		numero.showListNumbers();
	}
}
