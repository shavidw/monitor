package com.foeuor.rest.monitorweb.logics;

public class TempSensorLogic {
	
	public boolean checkTemp(double value) {
		return value>22 ? true : false;
	}

}
