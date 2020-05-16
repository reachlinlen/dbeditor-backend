package com.oo.dbeditor.vendor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendId;
	private String vendName;
	private int vendRanking;
	
	public Vendor() {
		
	}
	
	public Vendor(int vendId, String vendName, int vendRanking) {
		super();
		this.vendId = vendId;
		this.vendName = vendName;
		this.vendRanking = vendRanking;
	}
	
	public int getvendId() {
		return vendId;
	}

	public void setvendId(int vendId) {
		this.vendId = vendId;
	}

	public String getVendName() {
		return vendName;
	}

	public void setVendName(String vendName) {
		this.vendName = vendName;
	}

	public Number getVendRanking() {
		return vendRanking;
	}

	public void setVendRanking(int vendRanking) {
		this.vendRanking = vendRanking;
	}
}