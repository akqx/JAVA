package Projekt.Czynnosciowe;

import Projekt.Kreacyjne.Perfume;

public class PriceRise implements Command {
	private Perfume perfume;
	private Integer number;

	// reference to the light
	public PriceRise(Perfume perfume, Integer number) {
		this.perfume = perfume;
		this.number = number;
	}

	public void execute() {
		perfume.setPrice(perfume.getPrice() + number);
		System.out.println(perfume.toString());
	}
}