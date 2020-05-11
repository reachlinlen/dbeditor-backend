package com.oo.dbeditor.vendor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {
	
	@Id
	private String vendID;
	private String vendName;
	private Integer vendRanking;
	
	public Vendor() {
		
	}
	
	public Vendor(String vendID, String vendName, Integer vendRanking) {
		super();
		this.vendID = vendID;
		this.vendName = vendName;
		this.vendRanking = vendRanking;
	}
	
	public String getVendID() {
		return vendID;
	}

	public void setVendID(String vendID) {
		this.vendID = vendID;
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

	public void setVendRanking(Integer vendRanking) {
		this.vendRanking = vendRanking;
	}
}