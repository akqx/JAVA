package Projekt.Kreacyjne;

import java.util.ArrayList;
import java.util.List;
import Projekt.Czynnosciowe.Observable;
import Projekt.Czynnosciowe.Observer;

public class PerfumeShop implements Cloneable, Observer {

	private String shopName;
	private Observable observable = null;
	List<Perfume> perfume = new ArrayList<>();
	
	public PerfumeShop(Observable obvervable) {
		this.observable = observable;
	}

	public String getShopName() {
		return shopName;
	}

	public List<Perfume> getPerfume() {
		return perfume;
	}

	public void setPerfume(List<Perfume> perfume) {
		this.perfume = perfume;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	@Override
	public String toString() {
		return "PerfumeShop [shopName=" + shopName + ", perfume=" + perfume + "]";
	}

	@Override
	public void update(String name) {
		System.out.println("***WYPRZEDA¯!*** Od dziœ przez ca³y tydzieñ " + name + " taniej o 30%");
	}

}
