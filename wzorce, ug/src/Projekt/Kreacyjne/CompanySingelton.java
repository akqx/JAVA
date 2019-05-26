package Projekt.Kreacyjne;

import java.util.ArrayList;
import java.util.List;

public class CompanySingelton {
	private static CompanySingelton instance;

	private CompanySingelton() {
	}

	public static CompanySingelton getInstance() {
		if (instance == null) {
			instance = new CompanySingelton();
		}
		return instance;
	}

	public String[] getWorkingWith() {
		String[] company = { "Chanel", "CK", "D&G", "Avon", "Adidas", "NinaRichie" };
		return company;
	}
}
