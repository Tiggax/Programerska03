package psa.naloga3;

import java.lang.reflect.Constructor;

/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele.
 * Za funkcijo uporabite: h(x) = x * 53 mod 100
 * V primeru kolizij uporabite LINEARNO NASLAVLJANJE.
 */
public class HashTable2 {

	int[] data;

	public HashTable2(){
		int[] data = new int[1];
		this.data = data;
	}
	/*
	 * Metoda sprejme število in ga vstavi v tabelo. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean insert(int key) {
		for (int i : data) {
			if (key==i) {return false;}
		}
		int[] newdata = new int[this.data.length+1];
		for (int i : data) {
			newdata[i]=data[i];
		}
		newdata[newdata.length]= key;
		return true;
	}

	/*
	 * Metoda sprejme število in ga poišče v tabeli. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean search(int key) {
		for (int i : data) {
			if (key==i) {return true;}
		}
		return false;
	}

	/*
	 * Metoda sprejme število in ga izbriše iz tabele. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean delete(int key) {
		if ( search(key) == false ) {return false;}
		int[] newdata = new int[data.length-1];
		boolean isFound = false;
		for (int i : newdata) {
			if ( data[i] == key ) {
				isFound = true;
			}
			if (isFound) {
				newdata[i]= data[i];	
			} else {
				newdata[i]= data[i+1];
			}
		}
		this.data = newdata;
		return true;
	}
}
