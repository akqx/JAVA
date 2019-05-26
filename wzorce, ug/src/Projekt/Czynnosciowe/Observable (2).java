package Projekt.Czynnosciowe;

public interface Observable {

	public void removeObserver(Observer observer);

	public void notifyObservers(String name);

	public void addObserver(Observer observer);

	public String getName();
}
