package Projekt;

import Projekt.Kreacyjne.Perfume;
import Projekt.Kreacyjne.PerfumeShop;
import Projekt.Kreacyjne.WorkingWith;
import Projekt.Czynnosciowe.CommandSale;
import Projekt.Czynnosciowe.Observable;
import Projekt.Czynnosciowe.PriceReduction;
import Projekt.Czynnosciowe.PriceRise;
import Projekt.Strukturalne.*;

public class Test {

	public Test() {
		//Obserwator
		Observable obvervable = new Perfume("Gucci", 600);
		obvervable.notifyObservers(obvervable.getName());

		PerfumeShop gdanskShop = new PerfumeShop(obvervable);
		obvervable.addObserver(gdanskShop);
		//Prototyp
		PerfumeShop sopotShop = (PerfumeShop) gdanskShop.clone();

		Perfume chanel = new Perfume("Chanel", 500);
		Perfume dior = new Perfume("Dior", 400);
		Perfume ctrue = new Perfume("ctrue", 50);
		Perfume CK = new Perfume("CK", 150);
		Perfume adidas = new Perfume("Adidas", 15);
		Perfume DG = new Perfume("D&G", 150);
		Perfume avon = new Perfume("Avon", 15);
		Perfume NinaRichie = new Perfume("NinaRichie", 395);
        
		//Singleton
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
		
		//Kompozyt
		ShopComposite douglasSopot = new ShopComposite("(Sopot)", "sklep internetowy\n");
		ShopComposite douglasGdansk = new ShopComposite("(Gdansk)", "sklep stacjonarny\n");

		for (Perfume i : sopotShop.getPerfume()) {
			douglasSopot.dodaj(new ShopLeaf(i.getName(), String.valueOf(i.getPrice())));
		}

		for (Perfume i : gdanskShop.getPerfume()) {
			douglasGdansk.dodaj(new ShopLeaf(i.getName(), String.valueOf(i.getPrice())));
		}

		ShopComposite perfumy = new ShopComposite("DOUGLAS", "siec sklepów");
		perfumy.dodaj(douglasSopot);
		perfumy.dodaj(douglasGdansk);
		perfumy.getInfo();
        
		//Proxy
		ShopComponent proxy = new ProxyInformation("\n \nW Rossmanie", "sklep");
		for (Perfume i : sopotShop.getPerfume()) {
			proxy.dodaj(new ShopLeaf(i.getName(), String.valueOf(i.getPrice())));
		}

		proxy.getInfo();
		obvervable.notifyObservers(obvervable.getName());

		//Polecenie
		PriceReduction reduction = new PriceReduction(chanel, 100);
		PriceRise rise = new PriceRise(CK, 200);
		CommandSale sale = new CommandSale();
		sale.takeOrder(reduction);
		sale.takeOrder(rise);
		sale.placeOrders();

	}
}