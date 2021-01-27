package com.gesab.persistence.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gesab.entity.ContratEntity;

 
public interface ContratRepository extends JpaSpecificationExecutor<ContratEntity>, JpaRepository<ContratEntity, Integer> {
	
	ContratEntity findByAdresse(String adresse);
	@Query(value="SELECT * FROM T_CONTRAT where ID_ABONNE = :id ", nativeQuery = true)
	List<ContratEntity> findByIdentifiant(@Param("id") Integer identifiant);

}
