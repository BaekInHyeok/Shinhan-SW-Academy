package com.shinhan.day05;

public class ShopService {

	private static ShopService singleton;
	
	//생성자의 접근지정자를 private으로
	private ShopService() {

	}

	public static ShopService getInstance() {

		if (singleton == null)
			singleton = new ShopService();
		return singleton;
	}
}
