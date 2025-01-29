package com.Project.Repositories;
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
	@Query("update Batch b set b.batch_is_active = :batch_is_active where b.batch_id = :batch_id")
	void activateBatch(@Param("batch_is_active") Boolean batch_is_active,@Param("batch_id")int batch_id);


    @Query("SELECT b FROM Batch b WHERE b.batch_name = :batch_name")
    Optional<Batch> findByBatchName(@Param("batch_name") String batch_name);


}
