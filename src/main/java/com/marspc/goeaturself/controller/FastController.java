package com.marspc.goeaturself.controller;

import com.marspc.goeaturself.domain.Fast;
import com.marspc.goeaturself.service.FastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping(path = "get/startDateAndTime/{fastId}")
    public LocalDateTime getStartDateAndTime(@PathVariable("fastId") Long fastId){
       return fastService.getStartAndDateTime(fastId);
    }

    @GetMapping(path = "get/endDateAndTime/{fastId}")
    public LocalDateTime getEndDateAndTime(@PathVariable("fastId") Long fastId){
        return fastService.getEndDateAndTime(fastId);
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

    @PutMapping(path = "update/startDateAndTime/{fastId}/{startDateAndTime}")
    public void updateStartDateAndTime(@PathVariable("fastId") Long fastId,
                                       @PathVariable("startDateAndTime") String startDateAndTime){
        fastService.updateStartDateAndTime(fastId, startDateAndTime);
    }

    @PutMapping(path = "update/endDateAndTime/{fastId}/{endDateAndTime}")
    public void updateEndDateAndTime(@PathVariable("fastId") Long fastId,
                                       @PathVariable("endDateAndTime") String endDateAndTime){
        fastService.updateEndDateAndTime(fastId, endDateAndTime);
    }

    @PutMapping(path = "update/{fastId}/{targetFastTime}")
    public void updateTargetFastTime(@PathVariable("targetFastTime") Integer targetFastTime,
                                     @PathVariable("fastId") Long fastId){
        fastService.updateTargetFastTime(fastId, targetFastTime);
    }

}
