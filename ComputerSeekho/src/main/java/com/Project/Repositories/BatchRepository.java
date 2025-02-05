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
	void activateBatch(@Param("batchIsActive") Boolean batchIsActive,@Param("batchId")int batchId);

    @Query("SELECT b FROM Batch b WHERE b.batchName = :batchName")
    Optional<Batch> findByBatchName(@Param("batchName") String batchName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Batch SET batchIsActive = false WHERE batchName = :batchName", nativeQuery = true)
    int updateBatchIsActive(@Param("batchName") int batchId);

    @Query("SELECT b FROM Batch b WHERE b.batchIsActive = true")
    List<Batch> findAllActiveBatch();

    @Query(value = "SELECT * FROM Batch WHERE courseId = :courseId", nativeQuery = true)
    List<Batch> findByCourseId(@Param("courseId") int courseId);
}
