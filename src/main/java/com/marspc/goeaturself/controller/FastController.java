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

    @GetMapping(path = "get/targetFastTime/{fastId}")
    public Integer getTargetFastTime(@PathVariable("fastId") Long fastId){
        return fastService.getTargetFastTime(fastId);
    }

    @GetMapping(path = "get/isActive/{fastId}")
    public boolean getIsActive(@PathVariable("fastId") Long fastId){
        return fastService.getIsActive(fastId);
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
     First we type which Fast we want
     and then we type target fast time for update
     */
    @PutMapping(path = "update/userId/{fastId}/{targetFastTime}")
    public void updateTargetFastTime(@PathVariable("targetFastTime") Integer targetFastTime,
                                     @PathVariable("fastId") Long fastId){
        fastService.updateTargetFastTime(fastId, targetFastTime);
    }


    /*
    DELETE methods
     */
}
