package Projekt.Czynnosciowe;

import Projekt.Kreacyjne.Perfume;

public class PriceReduction implements Command {
	private Perfume perfume;
	private Integer number;

	// reference to the light
	public PriceReduction(Perfume perfume, Integer number) {
		this.perfume = perfume;
		this.number = number;
	}

	public void execute() {
		perfume.setPrice(perfume.getPrice() - number);
		System.out.println(perfume.toString());
	}
}