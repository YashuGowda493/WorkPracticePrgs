package com.test.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Players;
import com.test.model.PlayersMapper;

@Component
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
public class PlayerDao2 {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PlayerDao2(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		}
	private final String ins_sql="insert into players(id,p_name,p_team,p_price) values(?,?,?,?)";
	private final String upd_sql="update players set p_name=?,p_team=?,p_price=? where id=?";
	private final String del_sql="delete from players where id=?";
	private final String read_sql="select * from players";
	
	public boolean createPlayers(Players p) {
		return jdbcTemplate.update(ins_sql,p.getId(),p.getName(),p.getTeam(),p.getPrice())>0;
	}
	public boolean updatePlayers(Players p) {
		return jdbcTemplate.update(upd_sql,p.getName(),p.getTeam(),p.getPrice(),p.getId())>0;
	}
	public boolean deletePlayers(Players p) {
		return jdbcTemplate.update(del_sql,p.getId())>0;
	}
	public List<Players> listAll(){
		return jdbcTemplate.query(read_sql, new PlayersMapper());
	}

	

}
