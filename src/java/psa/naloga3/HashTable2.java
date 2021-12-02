package psa.naloga3;


/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele.
 * Za funkcijo uporabite: h(x) = x * 53 mod 100
 * V primeru kolizij uporabite LINEARNO NASLAVLJANJE.
 */
public class HashTable2 {

	int[] data;
	boolean[] santasHelper;

	public HashTable2() {
		this.data = new int[100];
		this.santasHelper = new boolean[100];
	}
	public int locateMe(int x) {
		int loc = 53 * x % 100;
			return Math.abs(loc);
	}

	/*
	 * Metoda sprejme število in ga vstavi v tabelo. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean insert(int key) {
		int loc = locateMe(key);
		if (search(key)) {
			return false;
		}
		int i = loc;
		while (!santasHelper[i]) {
			if (i == data.length - 1) {
				i = 0;
			} else {
				i++;
			}
		}
		this.data[i] = key;
		return true;
	}

	/*
	 * Metoda sprejme število in ga poišče v tabeli. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean search(int key) {
		int loc = locateMe(key);
		int i = loc;
		while (santasHelper[i]) {
			if ( data[i] == key ) {
				return true;
			}
			if (i == data.length - 1) {
				i = 0;
			} else {
				i++;
			}
		}
		return false;
	}

	/*
	 * Metoda sprejme število in ga izbriše iz tabele. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean delete(int key) {
		if (!search(key)) {return false;}
		int i = locateMe(key);
		while (santasHelper[i]) {
			if ( data[i] == key ) {
				santasHelper[i]= true;
				return true;
			}
			if (i == data.length - 1) {
				i = 0;
			} else {
				i++;
			}
		}
		return false;
	}
}
