package productorConsumidor;

public class Main {
	
	final static int MAX_PILA = 5;
	final static int MAX_PRODUCTOR= 10;
	final static int MAX_CONSUMIDOR = 5;
	
	public static void main(String[]args) {
		
		
		
		Monitor monitor = new Monitor(MAX_PILA);
		Productor productor = new Productor(monitor, MAX_PRODUCTOR);
		Consumidor consumidor = new Consumidor(monitor, MAX_CONSUMIDOR);
		
		Thread productores = new Thread(productor);
		Thread consumidores = new Thread(consumidor);
		
		productores.start();
		consumidores.start();
	}

}
