package Projekt.Czynnosciowe;

import Projekt.Czynnosciowe.Observer;

public class Client implements Observer {

	private Observable observable = null;

	// Constructor
	public Client(Observable observable) {
		this.observable = observable;
	}

	@Override
	public void update(String name) {
		System.out.println("WYPRZEDA¯"+name);
	}

	
}