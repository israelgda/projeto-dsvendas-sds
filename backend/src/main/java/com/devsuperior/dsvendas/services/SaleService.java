package com.devsuperior.dsvendas.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	private final SaleRepository repository;
	
	private final SellerRepository sellerRepository;
	
	public SaleService(SaleRepository repository, SellerRepository sellerRepository) {
		this.repository = repository;
		this.sellerRepository = sellerRepository;
	}
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return entityListToDTO(result);
	}
	
	private Page<SaleDTO> entityListToDTO(Page<Sale> entity){
		Page<SaleDTO> result = entity.map(x -> new SaleDTO(x));
		return result;
	}
}
