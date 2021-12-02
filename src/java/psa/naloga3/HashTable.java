package psa.naloga3;

/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele (HashTable).
 * Za funkcijo uporabite: h(x) = x * 701 mod 2000
 * V primeru kolizij uporabite VERIZENJE in sicer kot Slovar uporabite podatkovno 
 * strukturo Razprsilne tabele, ki ga morate implementirati (razred HashTable2). 
 * Pazite, ker je lahko ključ tudi negativno število
 */
public class HashTable {
	HashTable2[] data;

	public HashTable(){
		// h(x)= (701x) mod 2000
		this.data = new HashTable2[2000];
	}
	public int locateMe(int x) {
		int loc = 701 * x % 2000;
			return Math.abs(loc);
	}

	/*
	 * Metoda sprejme število in ga vstavi v tabelo. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean insert(int key) {
		int loc = locateMe(key);
		if ( data[loc] == null ) {this.data[loc] = new HashTable2();}
		return data[loc].insert(key);
	}

	/*
	 * Metoda sprejme število in ga poišče v tabeli. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean search(int key) {
		int loc = locateMe(key);
		return data[loc].search(key);
	}

	/*
	 * Metoda sprejme število in ga izbriše iz tabele. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean delete(int key) {
		int loc = locateMe(key);
		return data[loc].delete(key);
	}
}
