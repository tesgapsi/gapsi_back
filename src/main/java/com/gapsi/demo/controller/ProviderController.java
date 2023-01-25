package com.gapsi.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gapsi.demo.domain.Provider;
import com.gapsi.demo.repository.ProviderRepository;

/**
*
* @author jonatan.mendez
*/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProviderController {
	
	@Autowired
	ProviderRepository providerRepository;
	
	/**
     * Method with return provider list
     * @param name, max, offset
     * @return Provider List (Page<Provider>)
     * @throws ResponseEntity
     */
	@SuppressWarnings("unchecked")
	@GetMapping("/providers")
	
	public ResponseEntity<Page<Provider>> getAllProvider(@RequestParam(required = false) String name,@RequestParam(defaultValue = "0", required = false) Integer max, @RequestParam(defaultValue = "0", required = false) Integer offset) {
		try {
					
			Pageable pageable = (Pageable) PageRequest.of(offset, max);

			if(name == null) {
				return new ResponseEntity<>(providerRepository.findAll(pageable), HttpStatus.OK);	
			}else
				return new ResponseEntity<>(providerRepository.findAllByName(name, pageable), HttpStatus.OK);			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
     * Method with find provider by Id
     * @param Id
     * @return Provider
     * @throws ResponseEntity
     */
	@GetMapping("/provider/{id}")
	public ResponseEntity<Provider> getProviderById(@PathVariable("id") long id) {
		Optional<Provider> providerData = providerRepository.findById(id);

		if (providerData.isPresent()) {
			return new ResponseEntity<>(providerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
     * Method with create provider
     * @param Provider
     * @return Provider
     * @throws ResponseEntity
     */
	@PostMapping("/provider")
	public ResponseEntity<Object> createProvider(@RequestBody Provider provider) {
		
		try {
			Integer offset=0;
			Integer max=10;
			String message="El nombre ya se encuentra registrado";
			Pageable pageable = (Pageable) PageRequest.of(offset, max);
			
			List<Provider> findProvider= providerRepository.findAllByName(provider.getName(), pageable).getContent();
			if(findProvider.isEmpty())
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			
			Provider _provider = providerRepository.save(provider);
			return new ResponseEntity<>(_provider, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
     * Method with update provider
     * @param Provider
     * @return Provider
     * @throws ResponseEntity
     */
	@PutMapping("/provider/{id}")
	public ResponseEntity<Provider> updateProvider(@PathVariable("id") long id, @RequestBody Provider provider) {
		Optional<Provider> _providerData = providerRepository.findById(id);

		if (_providerData.isPresent()) {
			Provider _provider = _providerData.get();
			return new ResponseEntity<>(providerRepository.save(provider), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
     * Method with delete provider by Id
     * @param Id
     * @return status
     * @throws ResponseEntity
     */
	@DeleteMapping("/provider/{id}")
	public ResponseEntity<HttpStatus> deleteProvider(@PathVariable("id") long id) {
		try {
			providerRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
     * Method with delete all providers
     * @param 
     * @return status
     * @throws ResponseEntity
     */
	@DeleteMapping("/providers")
	public ResponseEntity<HttpStatus> deleteAllProviders() {
		try {
			providerRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
