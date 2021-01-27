package com.gesab.persistence.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.gesab.entity.MouvementEntity;

 
public interface MouvementRepository extends  JpaRepository<MouvementEntity, Integer> {

	@Query(value="SELECT * FROM T_MOUVEMENT where ID_ABONNE = :id ", nativeQuery = true)
	List<MouvementEntity> findMvmByIdentifiant(@Param("id") Integer identifiant);
}
