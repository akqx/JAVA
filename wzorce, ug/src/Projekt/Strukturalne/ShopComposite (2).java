package Projekt.Strukturalne;

import java.util.ArrayList;

public class ShopComposite extends ShopComponent {
	protected ArrayList<ShopComponent> skladowe = new ArrayList();

	public ShopComposite(String name, String type) {
		super(name, type);
	}

	public void dodaj(ShopComponent j) {
		skladowe.add(j);
	}

	@Override
	public void getInfo() {
		System.out.println(type + ": " + name + ", posiada: ");
		for (ShopComponent j : skladowe)
			j.getInfo();
	}
}