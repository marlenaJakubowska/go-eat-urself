package com.marspc.goeaturself.fast;

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


    @GetMapping
    public List<Fast> getFasts(){
        return fastService.getFasts();
    }

    @GetMapping(path = "targetfasttime/{fastId}")
    public Integer getTargetFastTime(@PathVariable("fastId") Long fastId){
        return fastService.getTargetFastTime(fastId);
    }

    @GetMapping(path = "isactive/{fastId}")
    public boolean getIsActive(@PathVariable("fastId") Long fastId){
        return fastService.getIsActive(fastId);
    }

    @GetMapping(path = "startdateandtime/{fastId}")
    public LocalDateTime getStartDateAndTime(@PathVariable("fastId") Long fastId){
       return fastService.getStartAndDateTime(fastId);
    }

    @GetMapping(path = "enddateandtime/{fastId}")
    public LocalDateTime getEndDateAndTime(@PathVariable("fastId") Long fastId){
        return fastService.getEndDateAndTime(fastId);
    }


    @PostMapping
    public void addNewFast(@RequestBody Fast fast){
        fastService.addNewFast(fast);
    }


    @PutMapping(path = "startdateandtime/{fastId}/{startDateAndTime}")
    public void updateStartDateAndTime(@PathVariable("fastId") Long fastId,
                                       @PathVariable("startDateAndTime") String startDateAndTime){
        fastService.updateStartDateAndTime(fastId, startDateAndTime);
    }

    @PutMapping(path = "enddateandtime/{fastId}/{endDateAndTime}")
    public void updateEndDateAndTime(@PathVariable("fastId") Long fastId,
                                       @PathVariable("endDateAndTime") String endDateAndTime){
        fastService.updateEndDateAndTime(fastId, endDateAndTime);
    }

    @PutMapping(path = "targetfasttime/{fastId}/{targetFastTime}")
    public void updateTargetFastTime(@PathVariable("targetFastTime") Integer targetFastTime,
                                     @PathVariable("fastId") Long fastId){
        fastService.updateTargetFastTime(fastId, targetFastTime);
    }

}
