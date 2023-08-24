package com.harshrathore.finalproject.apitestwithmockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.harshrathore.finalproject.controller.BikeManagementSystemController;
import com.harshrathore.finalproject.entity.Bike;
import com.harshrathore.finalproject.service.BikeManagementService;
@WebMvcTest(controllers = BikeManagementSystemController.class)
@AutoConfigureMockMvc(addFilters = false)
class Deleterequests {
@MockBean
private  BikeManagementService service;
@Autowired
private MockMvc mockMvc;
private static String url  = "http://localhost:8080/bms/77";
	@Test
	void deleteObjectNotFoundTest() throws Exception {
		String op = """
				{
    "maker_name":"KTM",
    "model_name":"RC390",
    "registration_Number":"Mh12jc4477",
    "chasis_number":24787,
    "known_issues":"Noises",
    "cost":12000,
    "given_date":"2023-02-11T12:18:54.101",
    "expected_deliveydate":"2023-09-25",
    "created_DateTime":"2023-02-11T12:18:54",
    "updated_DateTime":"2023-02-11T12:18:54",
    "address":"107,Setor 17 LG society Mumbai Maharashtra 400414",
    "phone_number":"7021687790"
    
}

				""";
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(url).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andReturn();
		System.out.println(result.getResponse().getStatus());
		assertEquals(404, result.getResponse().getStatus());
		System.out.println(result.getResponse().getContentAsString());
		//JSONAssert.assertEquals(op, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	void deletionSuccessful() throws Exception {
		String op = """
				{
    "maker_name":"KTM",
    "model_name":"RC390",
    "registration_Number":"Mh12jc4477",
    "chasis_number":24787,
    "known_issues":"Noises",
    "cost":12000,
    "given_date":"2023-02-11T12:18:54.101",
    "expected_deliveydate":"2023-09-25",
    "created_DateTime":"2023-02-11T12:18:54.101",
    "updated_DateTime":"2023-02-11T12:18:54.101",
    "address":"107,Setor 17 LG society Mumbai Maharashtra 400414",
    "phone_number":"7021687790"
    
}

				""";
		LocalDateTime parse = LocalDateTime.parse("2023-02-11T12:18:54.101");
	    LocalDate parse2 = LocalDate.parse("2023-09-25");
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("http://localhost:8080/bms/1").accept(MediaType.APPLICATION_JSON);
		Bike bike = new Bike("KTM","RC390","Mh12jc4477",24787,"Noises",12000,parse,parse2,parse,parse,"107,Setor 17 LG society Mumbai Maharashtra 400414","7021687790");
		when(service.getBike(anyInt())).thenReturn(bike);
		when(service.deleteBike(anyInt())).thenReturn("Deletion Succesful");
	    MvcResult result = mockMvc.perform(request).andReturn();
	    
		MockHttpServletResponse response = result.getResponse();
		assertEquals(202 ,response.getStatus());
		
	}

}
