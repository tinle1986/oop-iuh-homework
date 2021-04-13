package com.ttlecom.basics;

public class B10 {
	public static void main(String[] args) {
		// initialize products
		Product apple = new Product(111111, "iPhone 11", 899);
		Product samsung = new Product(222222, "Note 12", 729);
		Product oppo = new Product(333333, "Oppo A94", 599);
		Product vivo = new Product(444444, "Vivo 7", 499);
		Product xiaomi = new Product(555555, "Xiaomi Poco X3", 659);
		Product bphone = new Product(666666, "Bphone 8", 449);
		Product realme = new Product(777777, "Real Me 10x", 259);
		Product vsmart = new Product(888888, "vsmart 7R", 385);
		Product oneplus = new Product(999999, "one+ 12", 675);
		Product nokia = new Product(101010, "Nokia 8800", 456);
		Product huawei = new Product(202020, "Huawei Mate Pro 11", 783);
		Product mobell = new Product(303030, "Mobell XR5", 230);
		Product itel = new Product(404040, "iTel 500i", 150);
		Product masstel = new Product(505050, "Masstel thinbook", 342);
		Product energizer = new Product(606060, "Energizer Powerbank", 52);
//		System.out.println(energizer.toString());

		// make purchasing
		OrderDetail item1 = new OrderDetail(apple, 2);
		OrderDetail item2 = new OrderDetail(samsung, 1);
		OrderDetail item3 = new OrderDetail(xiaomi, 3);
		OrderDetail item4 = new OrderDetail(oneplus, 2);
		OrderDetail item5 = new OrderDetail(vivo, 5);
		OrderDetail item6 = new OrderDetail(energizer, 10);

		OrderDetail item7 = new OrderDetail(bphone, 5);
		OrderDetail item8 = new OrderDetail(oppo, 10);
		OrderDetail item9 = new OrderDetail(itel, 3);
		OrderDetail item10 = new OrderDetail(masstel, 1);
		OrderDetail item11 = new OrderDetail(realme, 5);
		OrderDetail item12 = new OrderDetail(nokia, 11);
		OrderDetail item13 = new OrderDetail(vsmart, 14);
		OrderDetail item14 = new OrderDetail(mobell, 21);
		OrderDetail item15 = new OrderDetail(huawei, 30);

		// make order
		Order order1 = new Order();
		order1.addLineItem(item1);
		order1.addLineItem(item2);
		order1.addLineItem(item3);
		order1.addLineItem(item4);
		order1.addLineItem(item5);
		order1.addLineItem(item6);

		Order order2 = new Order();
		order2.addLineItem(item7);
		order2.addLineItem(item8);
		order2.addLineItem(item9);
		order2.addLineItem(item10);
		order2.addLineItem(item11);
		order2.addLineItem(item12);
		order2.addLineItem(item13);
		order2.addLineItem(item14);
		order2.addLineItem(item15);

		// print order
		System.out.println(order1.toString());
		System.out.println(order2.toString());
	}
}
