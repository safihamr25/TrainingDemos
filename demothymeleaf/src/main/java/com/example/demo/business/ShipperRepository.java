package com.example.demo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipperRepository {
	private ShipperData dao;
	
	@Autowired
	public ShipperRepository(ShipperData shipper) {
		this.dao = shipper;
	}
	
	public List<Shipper> allShippers(){
		return dao.allShippers();
	}
	
	public Shipper getShipper(int id) {
		return dao.getShipperById(id);
	}
	
	public Shipper saveShipper(Shipper s) {
		return dao.editShipper(s);
	}
	
	public Shipper addShipper(Shipper s) {
		return dao.addShipper(s);
	}
	
	public void deleteShipper(int id) {
		dao.deleteShipper(id);
	}
	
}
