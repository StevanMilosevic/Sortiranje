package insertion;

/* Pocinjemo sa leve strane i to od indeksa br.1 i pomeramo tu vrednost u privremenu promenljivu, 
 * zatim ispitujemo taj element niza i uporedjujemo ga sa elementima sa njegove leve strane. 
 * Ako je element ili elementi sa leve strane veci od onog koji ispitujemo, menjamo im pozicije - INSERTUJEMO taj 
 * element u odgovarajuci polozaj u nizu.  
 *  */
public class Main {

	public static void main(String[] args) {
		int[] niz = {3, 8, 11, 19, 22, 4, 13, 1, 6, 2, 7, 15, 10, 5};
		
		// stampampo niz
		for(int i : niz)
			System.out.print(i + " ");
		
		sort(niz);
		System.out.println("\nNiz nakon insertion sorta: ");
		for(int i : niz)
			System.out.print(i + " ");
	}
	public static void sort(int[] niz) {
		// polazimo od indeksa 1, zato je i = 1
		for(int i = 1; i < niz.length; i++) {
			int temp = niz[i];	// privremena promenljiva
			int j = i - 1;		// podesavamo indeks na element pre (levo) od onog koji ispitujemo
			
			while(j >= 0 && niz[j] > temp) {
				niz[j + 1] = niz[j];	// ako se ispuni uslov, ovo pomera element na desno
				j--;					// dekrementujemo j za 1
			}
			// ostaje nam samo da onu sacuvanu vrednost u privremenoj promenljivoj insertujemo na mesto
			niz[j + 1] = temp;		// koje smo otvorili kada smo pomerili element u desno
		}
	}
}
