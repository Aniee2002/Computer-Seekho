package com.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.Project.Entities.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer>{
    @Modifying
	@Transactional
	@Query("update Video v set v.videoIsActive = :videoIsActive where v.videoId = :videoId")
	void activateVideo(@Param("videoIsActive") Boolean  videoIsActive,@Param("videoId")int videoId);

}
