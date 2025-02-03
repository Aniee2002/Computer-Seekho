package com.Project.Services;

import com.Project.Entities.ClosureReason;
import java.util.Optional;

public interface ClosureReasonService {
    Optional<ClosureReason> getClosureReasonById(Integer id);
    ClosureReason addClosureReason(ClosureReason closureReason);
}

