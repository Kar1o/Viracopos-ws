package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Player;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.ConnectData;

@RestController
public class PlayerController {
	
	private ConnectData connectData = new ConnectData();
	
	
	@RequestMapping("/player")
	public List<Player> player() throws SQLException{
		
		connectData.open();
		
		List<Player> player = new ArrayList<Player>();
		player = connectData.selectPlayers();
		
		connectData.close();
		return player;
		
	}
	
	
	@RequestMapping("/new_player")
	public void playerInsert(@RequestParam(value="name") String name, @RequestParam(value="score") int score) throws SQLException{
		
		connectData.open();
		
		connectData.insertPlayers(name, score);
		connectData.close();
		
	}

}
