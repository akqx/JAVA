package Projekt.Strukturalne;

public class ShopLeaf extends ShopComponent{
	public ShopLeaf(String name, String type) {
		super(name, type);
	}
	
	@Override
	public void getInfo() {
		System.out.println(type + ": " + name);
	}
}
