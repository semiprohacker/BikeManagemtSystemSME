package com.harshrathore.finalproject.apitestwithmockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.harshrathore.finalproject.entity.Bike;
import com.harshrathore.finalproject.repositary.BikeServiceSystemRepository;
import com.harshrathore.finalproject.service.BikeManagementService;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ExtendWith(MockitoExtension.class)
class ServiceLayerTest {
@MockBean
private BikeServiceSystemRepository repository;

@InjectMocks
private BikeManagementService service;
	@Test
	void testforFindByid() {
		LocalDateTime parse = LocalDateTime.parse("2023-02-11T12:18:54.101");
	    LocalDate parse2 = LocalDate.parse("2023-09-25");
		Bike bike =  new Bike("KTM","RC390","Mh12jc4477",24787,"Noises",12000,parse,parse2,parse,parse,"107,Setor 17 LG society Mumbai Maharashtra 400414","7021687790");
        Mockito.when(repository.findById(anyInt()))	.thenReturn(Optional.of(bike));
        assertEquals(bike, service.getBike(22));
	}
	
	@Test
	void testforAdd() {
		LocalDateTime parse = LocalDateTime.parse("2023-02-11T12:18:54.101");
	    LocalDate parse2 = LocalDate.parse("2023-09-25");
		Bike bike =  new Bike("KTM","RC390","Mh12jc4477",24787,"Noises",12000,parse,parse2,parse,parse,"107,Setor 17 LG society Mumbai Maharashtra 400414","7021687790");
        Mockito.when(repository.save(bike)).thenReturn(bike);
        assertEquals(bike, service.addRecord(bike));
	}
	@Test
	void testforFindByIDNotfound() {
		LocalDateTime parse = LocalDateTime.parse("2023-02-11T12:18:54.101");
	    LocalDate parse2 = LocalDate.parse("2023-09-25");
		Bike bike =  new Bike("KTM","RC390","Mh12jc4477",24787,"Noises",12000,parse,parse2,parse,parse,"107,Setor 17 LG society Mumbai Maharashtra 400414","7021687790");
        Mockito.when(repository.findById(anyInt())).thenReturn(Optional.empty());
        assertEquals(null, service.getBike(1));
	}
	


}
