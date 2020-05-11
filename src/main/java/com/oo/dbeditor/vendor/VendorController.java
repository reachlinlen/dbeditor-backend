package com.oo.dbeditor.vendor;


import org.springframework.web.bind.annotation.RestController;

import com.oo.dbeditor.vendor.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
		
	@GetMapping("/vendor")
	@CrossOrigin(origins = "http://localhost:8080")
	public List<Vendor> getVenTblDetails() {
		return vendorService.getAllVendorDetails();
				
	}	
	
	@PostMapping("/vendor")
	@CrossOrigin(origins = "http://localhost:8080")
	public void addVendorDetails(Vendor newVendor) {
		vendorService.addVendor(newVendor);
	}
}
