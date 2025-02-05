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

    @Query("SELECT b FROM Batch b WHERE b.batch_name = :batch_name")
    Optional<Batch> findByBatchName(@Param("batch_name") String batch_name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Batch SET batch_is_active = false WHERE batch_id = :batch_id", nativeQuery = true)
    int updateBatchIsActive(@Param("batch_id") int batch_id);

    @Query("SELECT b FROM Batch b WHERE b.batch_is_active = true")
    List<Batch> findAllActiveBatch();

    @Query(value = "SELECT * FROM Batch WHERE course_id = :course_id", nativeQuery = true)
    List<Batch> findByCourseId(@Param("course_id") int course_id);
}
