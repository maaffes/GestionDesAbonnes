package com.gesab.mapper;

import org.mapstruct.Mapper;
 
import com.gesab.dto.AbonneDto;
import com.gesab.dto.ContratDto;
import com.gesab.dto.MouvementDto;
import com.gesab.entity.AbonneEntity;
import com.gesab.entity.ContratEntity;
import com.gesab.entity.MouvementEntity;
 
@Mapper(componentModel = "spring")
public interface IAbonneMapper {

  AbonneEntity toAbonneEntity(AbonneDto abonneDto);

  AbonneDto toAbonneDto(AbonneEntity abonneEntity);

  ContratEntity tocontratEntity(ContratDto contratDto);

  ContratDto toContratDto(ContratEntity contratEntity);
  
  MouvementEntity toMvmEntity(MouvementDto mvmDto);
  
  MouvementDto toMvmDto(MouvementEntity mvmEntity);
}