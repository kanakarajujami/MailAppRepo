package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.IPurchaseMgmtService;

@RestController
@RequestMapping("/shop-api")
public class PurchaseMgmtController {
   @Autowired
	private IPurchaseMgmtService service;
   @GetMapping("/purchase")  
   public ResponseEntity<String>  doShopping() throws Exception {
	   String msg=service.shopping(new String[]{"kanakadude06@gmail.com","kanakarajujami99@gmail.com"}, new String[]{"Shirt","Trouser","Paint"},new Double[] {780.0,860.0,980.0});
	   return new ResponseEntity<String>(msg, HttpStatus.OK);
   }
}
