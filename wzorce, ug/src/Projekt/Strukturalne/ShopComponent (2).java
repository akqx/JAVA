package Projekt.Strukturalne;

public abstract class ShopComponent {
	protected String name;
	protected String type;

	public ShopComponent(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public void dodaj(ShopComponent j) {
	}

	public abstract void getInfo();
}
