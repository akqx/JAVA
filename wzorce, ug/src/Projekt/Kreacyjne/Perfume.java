package Projekt.Kreacyjne;

import java.util.ArrayList;
import java.util.List;
import Projekt.Czynnosciowe.Observable;
import Projekt.Czynnosciowe.Observer;

public class Perfume implements Observable, Cloneable {

	private int price;
	private String name;

	public Perfume(String name, int price) {
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Perfume [price=" + price + ", name=" + name + "]";
	}

	private List<Observer> users = new ArrayList<Observer>();

	@Override
	public void addObserver(Observer o) {
		users.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		users.remove(o);
		
	}

	@Override
	public void addObserver(java.util.Observer observer1) {
		// TODO Auto-generated method stub
		users.add((Observer) observer1);
		
	}

	@Override
	public void notifyObservers(String name) {
		// TODO Auto-generated method stub
		for(Observer user: users) {
			user.update(name);
		}
	
	}
}
