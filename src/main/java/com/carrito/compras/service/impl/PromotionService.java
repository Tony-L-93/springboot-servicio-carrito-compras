package com.carrito.compras.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compras.api.PromotionApi;
import com.carrito.compras.mapper.Mapper;
import com.carrito.compras.model.Promotion;
import com.carrito.compras.repository.PromotionRepository;

@Service
public class PromotionService {
	@Autowired
	private PromotionRepository promotionRepository;

	public void create(PromotionApi promotionApi) {
		Promotion promotion = Mapper.mapperToPromotion(promotionApi);
		promotionRepository.save(promotion);
	}

	public List<Promotion> findAll() {
		return promotionRepository.findAll();
	}

}
