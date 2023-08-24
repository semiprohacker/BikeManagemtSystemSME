package com.harshrathore.finalproject.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.harshrathore.finalproject.entity.Bike;
import com.harshrathore.finalproject.repositary.BikeServiceSystemRepository;

@Service
public class BikeManagementService {
  
  BikeServiceSystemRepository repository;
   BikeManagementService (BikeServiceSystemRepository repo){
	   this.repository=repo;
   }
   /**
    * Adds a new Bike record.
    * 
    * @param bike The Bike object to be added.
    * @return Bike The Bike object that has been successfully saved in the database.
    */
	public Bike addRecord(Bike bike) {
		Bike savedBike = repository.save(bike);
		return savedBike;
	}
	/**
	 * Retrieves a Bike record by its ID.
	 * 
	 * @param id The ID of the Bike to retrieve.
	 * @return Bike The Bike object with the specified ID, or null if the Bike with the given ID is not found in the database.
	 */
	public Bike getBike(int id) {
		  Optional<Bike> findById = repository.findById(id);
		  if (findById.isEmpty()) {
		   return null;
	}
		  return findById.get();
}
	
	/**
	 * Deletes a Bike record identified by its ID.
	 * 
	 * @param id The ID of the Bike to delete.
	 * @return String A message indicating the result of the deletion operation. Returns "Deletion Successful" 
	 * if the deletion is successful, or null if the Bike with the given ID is not found in the database.
	 */
	public String deleteBike(Integer id) {
		Optional<Bike> findByid = repository.findById(id);
		if(!findByid.isEmpty()) {
        repository.deleteById(id);
        return "Deletion Successful";}
			return null;}
	/**
	 * Updates a Bike record identified by its ID.
	 * 
	 * @param id   The ID of the Bike to update.
	 * @param bike The updated Bike object containing the new values.
	 * @return Bike The updated Bike object if the update is successful, null if the Bike with the given ID is not found in the database.
	 */

	public Bike updateBike(int id, Bike bike)  {
		Optional<Bike> byId = repository.findById(id);
		if(!byId.isEmpty()) {
			Bike exsistingEntry = byId.get();
			exsistingEntry.setKnown_issues(bike.getKnown_issues());
			exsistingEntry.setAddress(bike.getAddress());
			exsistingEntry.setPhone_number(bike.getPhone_number());
			exsistingEntry.setCost(bike.getCost());
			exsistingEntry.setExpected_deliveydate(bike.getExpected_deliveydate());
			exsistingEntry.setUpdated_DateTime(bike.getUpdated_DateTime());
			repository.save(exsistingEntry);
			return exsistingEntry;
			
		}
		else {
			return null;
		}
		
		
}
}
