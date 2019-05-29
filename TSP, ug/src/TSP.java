
import java.io.*;

public class TSP {
	private static int[][] odleglosc;
	private static int optymalnyKoszt = 1000;
	private static String optymalnaSciezka = "";

	public static void main(String args[]) throws IOException {
		odleglosc = new int[5][5];

		odleglosc[0][0] = 0;
		odleglosc[1][1] = 0;
		odleglosc[2][2] = 0;
		odleglosc[3][3] = 0;
		odleglosc[3][3] = 0;

		odleglosc[0][1] = 24;
		odleglosc[0][2] = 16;
		odleglosc[0][3] = 23;
		odleglosc[0][4] = 23;

		odleglosc[1][0] = 16;
		odleglosc[1][2] = 27;
		odleglosc[1][3] = 14;
		odleglosc[1][4] = 11;

		odleglosc[2][0] = 15;
		odleglosc[2][1] = 14;
		odleglosc[2][3] = 16;
		odleglosc[2][4] = 27;

		odleglosc[3][0] = 14;
		odleglosc[3][1] = 22;
		odleglosc[3][2] = 19;
		odleglosc[3][4] = 23;

		odleglosc[4][0] = 13;
		odleglosc[4][1] = 11;
		odleglosc[4][2] = 26;
		odleglosc[4][3] = 18;

		String sciezka = "";
		int[] wierzcholek = new int[5 - 1];

		for (int i = 1; i < 5; i++) {
			wierzcholek[i - 1] = i;
		}

		procedure(0, wierzcholek, sciezka, 0);
		System.out.print("Sciezka: " + optymalnaSciezka + ". koszt = " + optymalnyKoszt);
	}

	private static int procedure(int initial, int wierzcholki[], String sciezka, int aktualnyKoszt) {

		sciezka = sciezka + Integer.toString(initial) + " - ";
		int length = wierzcholki.length;
		int nowyKosztAktualny;
		// wyw³ywane na koñcu
		if (length == 0) {
			// odleg³osæ ostatniego do zera, wracmy z powrotem
			nowyKosztAktualny = aktualnyKoszt + odleglosc[initial][0];

			if (nowyKosztAktualny < optymalnyKoszt) {
				optymalnyKoszt = nowyKosztAktualny;
				optymalnaSciezka = sciezka + "0";
			}
			System.out.println(sciezka + "0 KOSZT:" + nowyKosztAktualny);
			return (odleglosc[initial][0]);

		} else if (aktualnyKoszt > optymalnyKoszt) {
			return 0;
		}

		else {
			int[][] nowyWierzcholek = new int[length][(length - 1)];
			int kosztTejGalezi, kosztDziecka;
			int najlepszyKoszt = 1000;

			// tworzenie nowych list wierzcho³ków
			for (int i = 0; i < length; i++) {
				for (int j = 0, k = 0; j < length; j++, k++) {

					// obecne dziecko nie jest brane pod uwage podczas tworzenie
					// tbalicy
					if (j == i) {
						k--;
						continue;
					}

					nowyWierzcholek[i][k] = wierzcholki[j];
				}

				// koszt odleglosci od rodzica do dziecka
				kosztTejGalezi = odleglosc[initial][wierzcholki[i]];
				nowyKosztAktualny = kosztTejGalezi + aktualnyKoszt;
				kosztDziecka = procedure(wierzcholki[i], nowyWierzcholek[i], sciezka, nowyKosztAktualny);

				int kosztCalkowity = kosztDziecka + nowyKosztAktualny;

				if (kosztCalkowity < najlepszyKoszt) {
					najlepszyKoszt = kosztCalkowity;
				}
			}
			return (najlepszyKoszt);
		}
	}
}