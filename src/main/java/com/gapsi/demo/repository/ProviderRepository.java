package com.gapsi.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gapsi.demo.domain.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
	
	// List<Provider> findByName(String name);
	 Page<Provider> findAllByName(String name, Pageable pageable);
	 Page<Provider> findAll( Pageable pageable);

}
