package productorConsumidor;

import java.util.ArrayList;

public class Monitor {
	
	private static ArrayList<Integer> numeros = null;
	private int size;
	
	public Monitor(int size) {
		this.size = size;
		Monitor.numeros = new ArrayList<Integer>(size);
	}
	
	public synchronized boolean addNumber(int number) {
		while (numeros.size() == size) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Error en addNumber: " +e);
			}
		}
		System.out.println("Produzco el numero: " +number);
		numeros.add(number);
		notifyAll();
		return true;
	}
	
	public synchronized boolean removeNumber() {
		if(!numeros.isEmpty()) {
			System.out.println("Consumo el numero " + numeros.get(0));
			numeros.remove(0);
			notifyAll();											
			return true;
		} else {
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Error en removeNumber: " +e);
			}												
			return false;
		}
	}
	
	public synchronized void showListNumbers() {
		if(numeros.isEmpty()) {									//Si la pila esta vacia imprimira un mensaje y si tiene numeros los imprimira.
			System.out.println("\nLista vacía.");
		}else {
			System.out.println();
			for(int i : numeros) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}

}
