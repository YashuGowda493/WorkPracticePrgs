package com.test;

import java.util.List;

public class OrderDemo {

	public static void main(String[] args) {
		OrderDao odao=new OrderDao();
		Order obj=new Order();
//		obj.setId(52);
//		obj.setO_name("Fruits");
//		obj.setO_quantity(3);
//		obj.setO_price(100);
		
		obj.setO_name("cake");
		obj.setO_quantity(2);
		obj.setO_price(400);
		odao.saveOrder(obj);
//		odao.updateOrder(obj);
//		odao.deleteOrder(obj);
		
		
		List<Order> list=odao.listAllOrders();
		list.forEach(dt->System.out.println(dt.getId()+" "+dt.getO_name()+" "+dt.getO_quantity()+" "+dt.getO_price()));
		
		System.out.println("Done");
		
		
		
				
				
	}

}
