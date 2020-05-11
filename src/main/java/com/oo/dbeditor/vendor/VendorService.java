package com.oo.dbeditor.vendor;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.oo.dbeditor.vendor.Vendor;
import com.oo.dbeditor.vendor.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class VendorService {
	
	@Autowired
	private VendorRepository vendorRepository;

	public List<Vendor> getAllVendorDetails() {
		List<Vendor> vendor = new ArrayList<>();
		vendorRepository.findAll()
				.forEach(vendor::add);
		return vendor;
	}
	
	public void addVendor(Vendor vendor) {
		vendorRepository.save(vendor);
	}

}
