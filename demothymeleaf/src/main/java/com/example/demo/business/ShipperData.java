package com.example.demo.business;

import java.util.List;

public interface ShipperData {
	public List<Shipper> allShippers();
	public Shipper getShipperById(int id);
	public Shipper editShipper(Shipper s);
	public void deleteShipper(int id);
	public Shipper addShipper(Shipper add);
	
}
