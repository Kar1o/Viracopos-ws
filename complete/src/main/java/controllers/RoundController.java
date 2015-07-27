package controllers;

import java.sql.SQLException;

import models.Round;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.ConnectData;

@RestController
public class RoundController {

	ConnectData connectData = new ConnectData();

	Round newRound = new Round();

	int totalRound;

	@RequestMapping("/question")
	public Round round(@RequestParam(value = "round") int round,
			@RequestParam(value = "index") int index) throws SQLException {
		connectData.open();
		totalRound = connectData.selectTotalRound();

		if (index > totalRound) {
			return null;
		}

		newRound = connectData.selectQuestions(round, index);
		connectData.close();
		return newRound;

	}
	
	@RequestMapping("/question_total")
	public int totalRound() throws SQLException {
		connectData.open();
		totalRound = connectData.selectTotalRound();
		connectData.close();
		return totalRound;
	}

}
