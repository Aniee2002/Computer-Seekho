package com.Project.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.ClosureReason;
import com.Project.Repositories.ClosureReasonRepository;

@Service
public class ColsureReasonServiceImpl implements ClosureReasonService{

    @Autowired
    private ClosureReasonRepository closureReasonRepository;
    
    @Override
    public Optional<ClosureReason> getClosureReasonById(Integer id) {
        return closureReasonRepository.findById(id);
    }

    @Override
    public ClosureReason addClosureReason(ClosureReason closureReason) {
        return closureReasonRepository.save(closureReason);
    }
    
}
