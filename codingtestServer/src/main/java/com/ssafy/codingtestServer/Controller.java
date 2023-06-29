package com.ssafy.codingtestServer;

import com.ssafy.codingtestServer.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Map;

@RestController
public class Controller {


    @PostMapping("/codingtest")
    public ResponseEntity<Map<String,Object>> codingtest(@RequestBody String sourceCode) throws IOException {

        String code = "package com.ssafy.codingtestServer;\n" + sourceCode;
        return Service.runCode(code);
    }
}

