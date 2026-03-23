package com.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.db.DbConnection;
import com.test.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public int saveCustomer(Customer obj) {
		int x=0;
		String query="insert into customer(c_name,email,city) values(?,?,?)";
		try {
		PreparedStatement ps=DbConnection.getCon().prepareStatement(query);
		ps.setString(1, obj.getName());
		ps.setString(2, obj.getEmail());
		ps.setString(3, obj.getCity());
		x=ps.executeUpdate();
		
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<Customer> listAllCustomers() {
		List<Customer> list = new ArrayList<>();
		try {
		String query = "select * from customer";
		PreparedStatement ps = DbConnection.getCon().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		
		while (rs.next()) {
			Customer obj = new Customer();
			obj.setId(rs.getInt(1));
			obj.setName(rs.getString(2));
			obj.setEmail(rs.getString(3));
			obj.setCity(rs.getString(4));
			list.add(obj);

		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
