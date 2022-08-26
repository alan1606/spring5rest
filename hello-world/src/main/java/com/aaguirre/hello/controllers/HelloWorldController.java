/**
 * 
 */
package com.aaguirre.hello.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alan
 *
 */

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

	@GetMapping
	public ResponseEntity<?> helloWorld(){
		return new ResponseEntity<String>("Hello, world, yeah", HttpStatus.OK);
	}
	
}
