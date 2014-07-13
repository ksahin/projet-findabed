package com.findabed.modeles;

import java.util.ArrayList;

public class Contenu<T,S> {
	
	private T valeurT;
	private S valeurS;
	private int id;
	
	public int getId() {
		return id;
	} 
	
	public void setId(int id) {
		this.id = id;
	}
	
	public S getValeurS() {
		return valeurS;
	}
	public void setValeurS(S valeurS) {
		this.valeurS = valeurS;
	}
	public T getValeurT() {
		return valeurT;
	}
	public void setValeurT(T valeurT) {
		this.valeurT = valeurT;
	}
	
	

}
