package bubble;

public class Main {

	public static void main(String[] args) {
		/*
		 * Bubble sort ne spada u najbrze nacine sortiranja, problem sa njim je sto se
		 * sa vecim brojem elemenata on "usporava". Tako da spada u sporije algoritme
		 * sortiranja, ima slozenost najgoreg slucaja O(n2) - sto znaci da sto vise
		 * elemenata mora da preuredi, to mu je potrebno vise vremena.
		 * 
		 * 
		 * Bubble sort prolazi kroz niz/listu od pocetka i uporedjuje svaku vrednost sa
		 * sledecom vrednoscu. Ako te dve vrednosti nisu u odrgovarajucem redosledu, on
		 * im menja mesta. Zatim nastavlja tako do kraja niza/liste. Kada dodje do kraja
		 * ponavlja postupak i zaustavlja se kada vise nema vrednosti koje mora da
		 * zameni. Tako ce da zna da je lista sortirana.
		 */

		int[] niz = { 8, 22, 2, 6, 32, 10, 4, 11, 7, 1 }; // niz koji treba preurediti

		// stampanje niza
		for (int i : niz) {
			System.out.print(i + " ");
		}
		/*
		 * Prolazimo kroz niz i proveravamo da li sledeca vrednost u odgovarajucem
		 * redosledu. Ako nisu, zamenicemo im mesta. Posto ce se FOR petlja izvrsiti
		 * samo jednom, potrebno je da je nateramo da se "vrti" sve dok ima elemenata
		 * niza kojima je potrebno zameniti mesta. U tu svrhu ce nam pomoci WHILE petlja
		 */

		boolean provera = true; // true ce uvek pokrenuti while()
		while (provera) {
			provera = false; // postavljamo boolean da nas izbaci iz while()
			// niz.length - 1 -> ovime smo se osigurali da ne prekoracimo broj clanova niza
			for (int j = 0; j < niz.length - 1; j++) {
				if (niz[j] > niz[j + 1]) {
					provera = true; // osim ako nema elemenata za zamenu
					int temp = niz[j];
					niz[j] = niz[j + 1];
					niz[j + 1] = temp;
				}
			}
		}
		// stampanje sortiranog niza
		System.out.println("\nNakon sortiranja niz izgleda: ");

		for (int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}
	}
}
