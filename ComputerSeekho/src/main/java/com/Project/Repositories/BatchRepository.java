package com.Project.Repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Project.Entities.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Integer>{
   @Modifying
	@Transactional
	@Query("update Batch b set b.batchIsActive = :batchIsActive where b.batchId = :batchId")
	void activateBatch(@Param("batchIsActive") Boolean batch_is_active,@Param("batchId")int batch_id);


    @Query("SELECT b FROM Batch b WHERE b.batchName = :batchName")
    Optional<Batch> findByBatchName(@Param("batchName") String batch_name);
}
