package com.marspc.goeaturself.controller;

import com.marspc.goeaturself.domain.Fast;
import com.marspc.goeaturself.service.FastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/fast")
public class FastController {

    private final FastService fastService;

    @Autowired
    public FastController(FastService fastService) {
        this.fastService = fastService;
    }

    @GetMapping
    public List<Fast> getFasts(){
        return fastService.getFasts();
    }
}
