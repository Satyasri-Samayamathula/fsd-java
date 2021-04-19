package com.ibm.train.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ibm.train.entity.Train;
import com.ibm.train.exception.InvalidTrainException;
import com.ibm.train.service.TrainService;

@RestController
public class TrainController {

	@Autowired
	private TrainService service;
	
	@PostMapping(value = "/train", consumes = "application/json")
	public String addTrain(@RequestBody Train t) {
		int code = service.addTrain(t);
		return "Train added with code: " + code;
	}
	
	@GetMapping(value = "/train/{code}", produces = "application/json")
	public Train getTrain(@PathVariable("code") int code) {
		Train t = null;
		try {
			t = service.getTrain(code);
		} catch (InvalidTrainException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(e.getMessage()));
		}
		return t;
	}
	
	@GetMapping(value = "/trains", produces = "application/json")
	public Collection<Train> getAll() {
		return service.getAll();
	}
}
