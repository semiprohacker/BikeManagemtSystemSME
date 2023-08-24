package com.harshrathore.finalproject.controller;

import java.net.URI;

import org.apache.catalina.connector.Response;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.harshrathore.finalproject.entity.Bike;
import com.harshrathore.finalproject.service.BikeManagementService;
import com.harshrathore.finalproject.service.BikeNotFoundException;

import jakarta.validation.Valid;
/**

Controller class that handles the API endpoints for the Bike Management System.
*/
@RestController
@RequestMapping(value = "/bms")
public class BikeManagementSystemController {
	BikeManagementService service;
	/**

	Constructor injection for the BikeManagementService dependency.
	@param service The BikeManagementService instance to be injected.
	*/
	public BikeManagementSystemController(BikeManagementService service) {
		this.service = service;
	}

//	@GetMapping("/")
//	public String getAllBikeStatus() {
//		return "All the bikes are here";
//	}


/**

This method handles the HTTP POST request for saving a new Bike record.
It takes a Bike object as a JSON payload in the request body and performs validation.
If there are validation errors, it returns a ResponseEntity with a 400 Bad Request status code
and the corresponding error messages as the response body.
If there are no validation errors, it adds the Bike record to the system and returns a ResponseEntity
with a 201 Created status code, the newly added Bike object as the response body, and includes
the location URI of the newly added Bike in the response headers.
@param bike The Bike object to be saved.
@param result The binding result of the validation process.
@return ResponseEntity The HTTP response containing the result of the operation.
*/
		@PostMapping("/save")
		public ResponseEntity<Object> addBike(@RequestBody @Valid Bike bike, BindingResult result) {
			if (result.hasErrors()) {
				StringBuilder builder = new StringBuilder();
				for (FieldError fe : result.getFieldErrors()) {
					builder.append(fe.getDefaultMessage());
					builder.append("\n");
				}
				return ResponseEntity.badRequest().body(builder.toString());
			}
			Bike newlyAddedBike = service.addRecord(bike);
			URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/bms/{id}")
					.buildAndExpand(newlyAddedBike.getId()).toUri();
			return ResponseEntity.created(location).body(newlyAddedBike);
		}

		/**

		Retrieves a Bike record by its ID.
		@param id The ID of the Bike to retrieve.
		@return Bike The Bike object with the specified ID.
		@throws BikeNotFoundException If the Bike with the given ID is not found in the database.
		*/
	@GetMapping("/{id}")
	public Bike getBike(@PathVariable int id) {
		Bike bike = service.getBike(id);
		if (bike == null) {
			throw new BikeNotFoundException("Bike with this id is not in our database");
		}
		return bike;

	}


/**

Deletes a Bike record by its ID.
@param id The ID of the Bike to delete.
@return ResponseEntity The HTTP response indicating the result of the operation.
@throws BikeNotFoundException If the Bike with the given ID is not found in the database.
*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Bike> deleteBike(@PathVariable Integer id) {
		Bike bike = service.getBike(id);
		if (bike == null) {
			throw new BikeNotFoundException("Bike with this id is not in our database");
		}
		service.deleteBike(id);
		return new ResponseEntity<Bike>(HttpStatus.ACCEPTED);

	}

	/**
	 * Updates a Bike record identified by its ID.
	 *
	 * @param id     The ID of the Bike to update.
	 * @param bike   The updated Bike object received as a JSON payload in the request body.
	 * @param result The binding result of the validation process.
	 * @return ResponseEntity The HTTP response containing the result of the operation.
	 *         If there are validation errors, it returns a ResponseEntity with a 400 Bad Request status code
	 *         and the corresponding error messages as the response body.
	 *         If the Bike with the given ID is not found in the database, it throws a BikeNotFoundException.
	 *         If the update is successful, it returns a ResponseEntity with a 201 Created status code
	 *         and the updated Bike object as the response body.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBike(@PathVariable int id, @RequestBody @Valid Bike bike,
			BindingResult result) {

		if (result.hasErrors()) {
			StringBuilder builder = new StringBuilder();
			for (FieldError fe : result.getFieldErrors()) {
				builder.append(fe.getDefaultMessage());
				builder.append("\n");
			}
			return ResponseEntity.badRequest().body(builder.toString());
		}

		Bike updateBike = service.updateBike(id, bike);
		if (updateBike == null) {
			throw new BikeNotFoundException("Bike with this id is not in our database");
		}
		return new ResponseEntity<>(updateBike, HttpStatus.CREATED);

	}
}
