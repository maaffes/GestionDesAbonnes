package com.gesab.services.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
 
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.gesab.dto.AbonneDto;
import com.gesab.dto.ContratDto;
import com.gesab.dto.MouvementDto;
import com.gesab.entity.AbonneEntity;
import com.gesab.entity.ContratEntity;
import com.gesab.entity.MouvementEntity;
import com.gesab.mapper.IAbonneMapper;
import com.gesab.persistence.repository.AbonneRepository;
import com.gesab.persistence.repository.ContratRepository;
import com.gesab.persistence.repository.MouvementRepository;


 
@RunWith(MockitoJUnitRunner.class)
class AbonneServiceImplTest {
	@InjectMocks
	private AbonneServiceImpl abonneServiceImpl= new  AbonneServiceImpl();
	@Mock
	MouvementRepository mouvementRepository;

	@Mock
	AbonneRepository abonneRepository;

	@Mock
	private ContratRepository contratRepository;

	@Mock
	private IAbonneMapper mapper ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		abonneServiceImpl = new AbonneServiceImpl();
		MockitoAnnotations.initMocks(this);
	}


	@Test
	final void testCreateAbonne() {
		AbonneDto abonneDto = new AbonneDto("Affes", "Amine", "paris france");
		AbonneEntity abonneEntity = new AbonneEntity("Affes", "Amine", "paris france");
		abonneEntity.setIdentifiant(111);
		abonneDto.setIdAbonne(111);
		when(abonneRepository.save(abonneEntity)).thenReturn(abonneEntity);
		when(mapper.toAbonneEntity(abonneDto)).thenReturn(abonneEntity);
		
		abonneServiceImpl.createAbonne("Affes", "Amine", "paris france");
 		(verify(abonneServiceImpl)).createAbonne("Affes", "Amine", "paris france");
	}

	@Test
	final void testAddContrat() {
		ContratDto ContratDto = new ContratDto("paris france");
		ContratEntity ContratEntity = new ContratEntity("paris france");
		ContratEntity.setIdentifiant(1);
		when(mapper.tocontratEntity(ContratDto)).thenReturn(ContratEntity);
		abonneServiceImpl.addContrat(1, "paris");

		(verify(abonneServiceImpl)).addContrat(1, "paris");
	}

	@Test
	final void testUpdateAdress() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetContrat() {
		List<ContratEntity> contratEntityList = new ArrayList<ContratEntity>();
		ContratEntity contratEntity = new ContratEntity("ass");
		contratEntityList.add(contratEntity);
		ContratDto contratDto = new ContratDto("ass");
		// When
		when(contratRepository.findByIdentifiant(1)).thenReturn(contratEntityList);
		when(mapper.toContratDto(contratEntity)).thenReturn(contratDto);
		// Then
		assertNotNull(abonneServiceImpl.getContrat(1));
	}
 


	@Test
	final void testGetMouvement() {
		List<MouvementEntity> mvmEntityList = new ArrayList<MouvementEntity>();
		MouvementEntity mvmEntity = new MouvementEntity(1, 1, "ss", "ee", "ddd", "ddd");
		mvmEntityList.add(mvmEntity);
		MouvementDto mvmDto = new MouvementDto(1, 1, "ss", "ee", "ddd", "ddd");
		// When
		when(mouvementRepository.findMvmByIdentifiant(1)).thenReturn(mvmEntityList);
		when(mapper.toMvmDto(mvmEntity)).thenReturn(mvmDto);
		// Then
		assertNotNull(abonneServiceImpl.getMouvement(1));
	}

}
