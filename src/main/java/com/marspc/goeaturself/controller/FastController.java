package com.marspc.goeaturself.controller;

import com.marspc.goeaturself.domain.Fast;
import com.marspc.goeaturself.service.FastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/fast")
public class FastController {

    private final FastService fastService;

    @Autowired
    public FastController(FastService fastService) {
        this.fastService = fastService;
    }

    /*
    GET methods
     */
    @GetMapping
    public List<Fast> getFasts(){
        return fastService.getFasts();
    }


    /*
    POST methods
     */
    @PostMapping
    public void addNewFast(@RequestBody Fast fast){
        fastService.addNewFast(fast);
    }


    /*
    PUT methods
     */

    /*
    TODO: Update Fast by userId, previousFastId,
      targetFastTime, startDateAndTime,
      endDateAndTime, isActive
     */
    @PutMapping(path = "{fastId}")
    public void updateFast(@PathVariable("fastId") Long fastId){
        fastService.updateFast(fastId);
    }


    /*
    DELETE methods
     */
}
