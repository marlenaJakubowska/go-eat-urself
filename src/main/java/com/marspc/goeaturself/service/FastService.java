package com.marspc.goeaturself.service;

import com.marspc.goeaturself.domain.Fast;
import com.marspc.goeaturself.repository.FastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FastService {
    
    private final FastRepository fastRepository;

    @Autowired
    public FastService(FastRepository fastRepository) {
        this.fastRepository = fastRepository;
    }


    public List<Fast> getFasts() {
        return fastRepository.findAll();
    }

    public Integer getTargetFastTime(Long fastId) {
        checkIfFastExist(fastId);
        Fast fast = fastRepository.getOne(fastId);
        return fast.getTargetFastTime();
    }

    public boolean getIsActive(Long fastId) {
        checkIfFastExist(fastId);
        Fast fast = fastRepository.getOne(fastId);
        return fast.isActive();
    }

    public LocalDateTime getStartAndDateTime(Long fastId) {
        checkIfFastExist(fastId);
        Fast fast = fastRepository.getOne(fastId);
        return fast.getStartDateAndTime();
    }

    public LocalDateTime getEndDateAndTime(Long fastId) {
        checkIfFastExist(fastId);
        Fast fast = fastRepository.getOne(fastId);
        return fast.getEndDateAndTime();
    }


    public void addNewFast(Fast fast) {
        fastRepository.save(fast);
    }


    @Transactional
    public void updateTargetFastTime(Long fastId, Integer targetFastTime) {
        checkIfFastExist(fastId);
        Fast fast = fastRepository.getOne(fastId);
        fast.setTargetFastTime(targetFastTime);
    }

    @Transactional
    public void updateStartDateAndTime(Long fastId, String startDateAndTime) {
        checkIfFastExist(fastId);
        LocalDateTime localDateTime = convertStringToLocalDateTime(startDateAndTime);
        Fast fast = fastRepository.getOne(fastId);
        fast.setStartDateAndTime(localDateTime);
    }

    @Transactional
    public void updateEndDateAndTime(Long fastId, String endDateAndTime) {
        checkIfFastExist(fastId);
        LocalDateTime localDateTime = convertStringToLocalDateTime(endDateAndTime);
        Fast fast = fastRepository.getOne(fastId);
        fast.setEndDateAndTime(localDateTime);
    }


    private void checkIfFastExist(Long fastId) {
        boolean isFastInDb = fastRepository.existsById(fastId);
        if (!isFastInDb){
            throw new IllegalStateException("Fast does not exist in database");
        }
    }

    private LocalDateTime convertStringToLocalDateTime(String startDateAndTime) {
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(startDateAndTime,dateTimeFormatter);
    }

}
