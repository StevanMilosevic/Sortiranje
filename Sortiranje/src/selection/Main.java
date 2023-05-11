package selection;

/* Selection sort ne spada u najbrze nacine sortiranja, pre svega zato sto koristi ugnjezdene petlje
 * dobar je za male kolicine podataka, slicno bubble sortu - ima slozenost najgoreg slucaja,
 * sto vise elemenata mora da preuredi, to mu je potrebno vise vremena.
 *  
 *  Selection sort uvodi dve privremene promenljive, u kojima cuva najmanju vrednost kao i vrednost 
 *  koju menja sa tom najmanjom nakon svake iteracije. */

public class Main {
	public static void main(String[] args) {
		int[] niz = { 12, 3, 27, 16, 9, 5, 11, 23, 7, 28, 1, 4 };

		for (int i : niz) {
			System.out.print(i + " ");
		}

		/*
		 * Ideja je: spoljna petlja uzima element koji ispitujemo da li je najmanji, pa
		 * ga uporedjujemo sa elemntima koje vrti unutrasnja petlja. Zato spoljasnja
		 * petlja ide do predzadnjeg elementa, a unutrasnja petlja krece od prvog
		 * elementa nakon uzetog elementa za ispitivanje i ide do kraja niza.
		 */

		for (int i = 0; i < niz.length - 1; i++) {
			int min = i; 					// uzimamo da je ovo najmanji element
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[min] > niz[j]) {
					min = j;
				}
			}
			// menjamo mesta elementima
			int temp = niz[i];
			niz[i] = niz[min];
			niz[min] = temp;
		}

		System.out.println("\nNiz nakon sortiranja: ");
		for (int i : niz)
			System.out.print(i + " ");

	}
}
