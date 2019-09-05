package pa.bgeneral.payroll.starter.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("${bg.endpoint.base}")
@Api(value = "STARTER", description = "A Test Controller")
public class StarterController {

    @GetMapping(path = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(
            value = "hello", 
            notes = "Endpoint fot testing purpose")
    public String start(){
        return "Hello BGx";
    }
}