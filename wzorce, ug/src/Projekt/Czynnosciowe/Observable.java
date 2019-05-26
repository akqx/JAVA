package Projekt.Czynnosciowe;

public interface Observable {

	public void addObserver(java.util.Observer observer1);
	public void removeObserver(Observer o);
	public void notifyObservers(String name);
	void addObserver(Observer o);
	public String getName();
}
