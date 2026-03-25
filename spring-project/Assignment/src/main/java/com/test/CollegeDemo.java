package com.test;

import java.util.List;

public class CollegeDemo {

	public static void main(String[] args) {
		CollegeDao cdao=new CollegeDao();
		College obj=new College();
		obj.setId(52);
//		obj.setO_name("Fruits");
//		obj.setO_quantity(3);
//		obj.setO_price(100);
		
		obj.setClg_name("pesidency");
		obj.setClg_city("yelahka");
		obj.setClg_pincode(560058);
		obj.setYear(1998);
//		cdao.saveCollege(obj);
//		cdao.updateCollege(obj);
		cdao.deleteCollege(obj);
		
		
		List<College> list=cdao.listAllCollege();
		list.forEach(dt->System.out.println(dt.getId()+" "+dt.getClg_name()+" "+dt.getClg_city()+" "+dt.getClg_pincode()+" "+dt.getYear()));
		
		System.out.println("Done");
		
		
		
				
				
	}

}
