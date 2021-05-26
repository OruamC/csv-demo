package com.readcsv.democsv.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.readcsv.democsv.service.EscolaService;

@Controller
@RequestMapping(value = "/escola")
public class EscolaController {

	private EscolaService escolaService;

	@Autowired
	public EscolaController(EscolaService escolaService) {
		this.escolaService = escolaService;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<Void> saveData(@RequestParam(name = "document") MultipartFile file) throws FileNotFoundException {
		if(file.isEmpty()) {
			throw new FileNotFoundException();
		}
		escolaService.saveData(file);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
