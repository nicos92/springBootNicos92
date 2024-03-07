package com.nicosandoval.SpringSecurity.persistence.repositories;

import com.nicosandoval.SpringSecurity.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select * from user_entity where email= :email", nativeQuery = true)
    Optional<UserEntity> findByEmail(@Param("email") String email);

    /*
    @Query(value = "select l from TnncSetlmtSvcGrpStagingEntity l where l.runDate >=:runDate")
    List<TnncSetlmtSvcGrpStagingEntity> findAllByRunDateGT(@Param("runDate") Date runDate);
     */


}
