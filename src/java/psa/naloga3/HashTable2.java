package psa.naloga3;

import java.lang.reflect.Constructor;

/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele.
 * Za funkcijo uporabite: h(x) = x * 53 mod 100
 * V primeru kolizij uporabite LINEARNO NASLAVLJANJE.
 */
public class HashTable2 {

	int[] data;
	boolean[] santasHelper;

	public HashTable2() {
		int[] data = new int[100];
		boolean[] hlp = new boolean[100];
		this.data = data;
		this.santasHelper = hlp;
	}

	/*
	 * Metoda sprejme število in ga vstavi v tabelo. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean insert(int key) {
		int loc = 53 * key % 100;
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
		data[i] = key;
		return true;
	}

	/*
	 * Metoda sprejme število in ga poišče v tabeli. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean search(int key) {
		int loc = 53 * key % 100;
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
		if (search(key) == false) {
			return false;
		}
		int[] newdata = new int[data.length - 1];
		boolean isFound = false;
		for (int i : newdata) {
			if (data[i] == key) {
				isFound = true;
			}
			if (isFound) {
				newdata[i] = data[i];
			} else {
				newdata[i] = data[i + 1];
			}
		}
		this.data = newdata;
		return true;
	}
}
