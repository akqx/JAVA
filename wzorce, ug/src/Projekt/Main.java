package Projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import Projekt.Kreacyjne.Perfume;
import Projekt.Kreacyjne.PerfumeShop;
import Projekt.Kreacyjne.WorkingWith;
import Projekt.Czynnosciowe.Client;
import Projekt.Czynnosciowe.Observable;
import Projekt.Kreacyjne.CompanySingelton;
import Projekt.Strukturalne.*;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		Observable obvervable = new Perfume("Gucci", 600);
		obvervable.notifyObservers(obvervable.getName());
		
		PerfumeShop gdanskShop= new PerfumeShop(obvervable);
		obvervable.addObserver(gdanskShop);
		
		PerfumeShop sopotShop = (PerfumeShop) gdanskShop.clone();

		Perfume chanel = new Perfume("Chanel", 500);
		Perfume dior = new Perfume("Dior", 400);
		Perfume ctrue = new Perfume("ctrue", 50);
		Perfume CK = new Perfume("CK", 150);
		Perfume adidas = new Perfume("Adidas", 15);
		Perfume DG = new Perfume("D&G", 150);
		Perfume avon = new Perfume("Avon", 15);
		Perfume NinaRichie = new Perfume("NinaRichie", 395);

		WorkingWith perfumWorking = new WorkingWith();
		perfumWorking.add(chanel);
		perfumWorking.add(dior);
		perfumWorking.add(ctrue);
		perfumWorking.add(adidas);
		perfumWorking.add(CK);
		sopotShop.setPerfume(perfumWorking.getPerfumList());
		gdanskShop.setPerfume(perfumWorking.getPerfumList());

		perfumWorking.add(avon);
		perfumWorking.add(NinaRichie);
		perfumWorking.add(DG);
	

		ShopComposite douglasSopot = new ShopComposite("(Sopot)", "sklep internetowy\n");
		ShopComposite douglasGdansk = new ShopComposite("(Gdansk)", "sklep stacjonarny\n");
		
		for (Perfume i : sopotShop.getPerfume()) {
			douglasSopot.dodaj(new ShopLeaf(i.getName(), String.valueOf(i.getPrice())));
		}
		
		for (Perfume i : gdanskShop.getPerfume()) {
			douglasGdansk.dodaj(new ShopLeaf(i.getName(), String.valueOf(i.getPrice())));
		}

		ShopComposite perfumy = new ShopComposite("DOUGLAS", "sieæ sklepów");
		perfumy.dodaj(douglasSopot);
		perfumy.dodaj(douglasGdansk);
		perfumy.getInfo();

		ShopComponent proxy = new ProxyInformation("\n \nW Rossmanie", "sklep");
		for (Perfume i : sopotShop.getPerfume()) {
			proxy.dodaj(new ShopLeaf(i.getName(), String.valueOf(i.getPrice())));
		}

		proxy.getInfo();
		obvervable.notifyObservers(obvervable.getName());
	}
}
