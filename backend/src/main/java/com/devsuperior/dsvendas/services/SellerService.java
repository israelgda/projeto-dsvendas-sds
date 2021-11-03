package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	
	private final SellerRepository repository;
	
	public SellerService(SellerRepository repository) {
		this.repository = repository;
	}
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		return entityListToDTO(result);
	}
	
	private List<SellerDTO> entityListToDTO(List<Seller> entity){
		List<SellerDTO> result = entity.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
		return result;
	}
	
}
