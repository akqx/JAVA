package Projekt.Strukturalne;

import java.util.ArrayList;

public class ProxyInformation  extends ShopComponent {
	
	ShopComposite composite;
	protected ArrayList<ShopComponent> skladowe = new ArrayList<ShopComponent>();
	
	public ProxyInformation(String name, String type) {
		super(name, type);
	}
	@Override
	public void getInfo() {
		System.out.println(   name +" brakuje");
		for (ShopComponent j : skladowe)
			j.getInfo();
	}

	public void dodaj(ShopComponent j) {
		skladowe.add(j);
	}

}
