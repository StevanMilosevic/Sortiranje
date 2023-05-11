package heap;

/* Ovaj algoritam za sortiranje je veoma efikasan, vreme potrebno da se izvrsi heap sort se logaritamski
 * povecava dok se vreme za druge vrste sortiranja povecava eksponencijalno kako raste broj elemenata niza
 * koji treba da se sortira.
 * Upotreba memorije je minimalna, posto je ovom algoritmu potrebna samo inicijalna memorija koja drzi niz
 * Nedostatak heap sorta je da nije efikasan kada radi sa kompleksnim tipovima podataka.
 * 
 * Metode ispod, sta rade: Posto je Heap nalik drvetu (tree), ali je uglavnom implementiran kao niz 
 * (uredjeno binarno stablo), pravilo prilikom pravljenja heap-a je da svaki red mora da bude kompletan 
 * sto znaci da mora postojati element u svakom od nodova (cvorova) osim poslednjeg reda. 
 * Zato pravimo heap stablo gde se najveci element postavlja kao root node, zatim taj najveci element menjamo
 *  sa onim na kraju niza, menjamo im mesta - onaj najveci prelazi na poslednje mesto u nizu i smatramo ga sortiranim. 
 *  Onda pozivamo heapify() metodu, posto nam je sad deo niza sortiran, ona pravi subtree od onog dela niza koji nije
 *  sortiran, pa opet se postavlja heap stablo, najveci element ide na root node, menjamo ga za onaj na kraju niza, 
 *  prelazi na kraj niza i smatra se sortiranim. 
 *  
 * Takodje je pravilo da su kljucevi roditelja veci od dece
 * 
 * U sustini konstantno cemo praviti heap stablo kako bi pronasli najveci element, da bi ga zatim pomerili 
 * iz heap-a i ubacili ga u sortiran niz   */

public class Main {

	public static void main(String[] args) {
		int[] niz = {9, 32, 11, 15, 6, 10, 21, 8, 3, 1, 14, 7, 16};
		for (int i : niz)
			System.out.print(i + " ");

		heapSort(niz);
		
		System.out.println("\nNiz nakon heap sorta: ");
		for(int i : niz)
			System.out.print(i + " ");
	}

	public static void heapSort(int[] niz) {
		
		// pravimo heap (preuredjujemo niz)
		for (int i = niz.length / 2 - 1; i >= 0; i--)
			heapify(niz, niz.length, i);

		// jedan po jedan izbacujemo elemente iz heap-a
		for (int i = niz.length - 1; i > 0; i--) {
			
			// Pomeramo tekuci root na kraj
			int temp = niz[0];
			niz[0] = niz[i];
			niz[i] = temp;

			// zovemo heapify nad polu sortiranim nizom
			heapify(niz, i, 0);
		}
	}

	// Heapify pravi sub-tree, ciji root je  int i -> koji je index od niz[]. n je velicina heap-a
	
	static void heapify(int[] niz, int n, int i) {
		int najveci = i; 			// Inicijalizujemo najveci kao root node
		int l = 2 * i + 1; 			// levi je = 2 * i + 1
		int r = 2 * i + 2; 			// desni je = 2 * i + 2

		// Ako je levi child veci od root-a
		if (l < n && niz[l] > niz[najveci])
			najveci = l;

		// Ako je desni child veci od najveceg 
		if (r < n && niz[r] > niz[najveci])
			najveci = r;

		// Ako najveci nije root
		if (najveci != i) {
			int temp = niz[i];
			niz[i] = niz[najveci];
			niz[najveci] = temp;

			// Rekurzija heapify 
			heapify(niz, n, najveci);
		}
	}
}
