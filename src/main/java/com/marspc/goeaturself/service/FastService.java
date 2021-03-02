package com.marspc.goeaturself.service;

import com.marspc.goeaturself.domain.Fast;
import com.marspc.goeaturself.repository.IFastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FastService {
    
    private final IFastRepository iFastRepository;

    @Autowired
    public FastService(IFastRepository iFastRepository) {
        this.iFastRepository = iFastRepository;
    }

    public List<Fast> getFasts() {
        return iFastRepository.findAll();
    }

    public void addNewFast(Fast fast) {
        iFastRepository.save(fast);
    }

    @Transactional
    public void updateTargetFastTime(Long fastId, Integer targetFastTime) {
        checkIfFastExist(fastId);
        Fast fast = iFastRepository.getOne(fastId);
        fast.setTargetFastTime(targetFastTime);
    }

    private void checkIfFastExist(Long fastId) {
        boolean isFastInDb = iFastRepository.existsById(fastId);
        if (!isFastInDb){
            throw new IllegalStateException("Fast does not exist in database");
        }
    }

    public Integer getTargetFastTime(Long fastId) {
        checkIfFastExist(fastId);
        Fast fast = iFastRepository.getOne(fastId);
        return fast.getTargetFastTime();
    }
}
