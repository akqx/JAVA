package Projekt.Kreacyjne;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Projekt.Czynnosciowe.Observable;
import Projekt.Czynnosciowe.Observer;
import Projekt.Czynnosciowe.Observer;
public class PerfumeShop implements Cloneable, Observer {

	private String shopName;
	List<Perfume> perfume = new ArrayList<>();
	private Observable observable = null;
	public PerfumeShop(Observable obvervable) {
		// TODO Auto-generated constructor stub
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
		System.out.println("***WYPRZEDA¯!*** Od dziœ przez ca³y tydzieñ "+ name +" taniej o 30%");
	}

}
