package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
//@RequestMapping("/api")
//@Api(tags = "Your API")

public class Controller {


    /*@PostMapping(path="/nothello")
    public String setname(@RequestBody String name) {
        System.out.println("1");
        return String.format("hello ");
    }*/
//    @GetMapping("/swagger")
//    @ApiOperation("Description of your endpoint")
//    public ResponseEntity<String> yourEndpoint() {
//        // Endpoint implementation
//        return ResponseEntity.ok("Hello, World!");
//    }

}
