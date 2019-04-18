package org.softuni.onlinegrocery.service;

import org.modelmapper.ModelMapper;
import org.softuni.onlinegrocery.domain.entities.Offer;
import org.softuni.onlinegrocery.domain.entities.Product;
import org.softuni.onlinegrocery.domain.models.service.OfferServiceModel;
import org.softuni.onlinegrocery.domain.models.service.ProductServiceModel;
import org.softuni.onlinegrocery.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.softuni.onlinegrocery.util.constants.AppConstants.*;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ProductService productService, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferServiceModel> findAllOffers() {
        return this.offerRepository.findAll().stream()
                .map(o -> this.modelMapper.map(o, OfferServiceModel.class))
                .collect(Collectors.toList());
    }

    @Scheduled(fixedRate = OFFER_SCHEDULED_FIX_RATE)
    private void generateOffers() {
        this.offerRepository.deleteAll();
        List<ProductServiceModel> products = this.productService
                .findAllProducts().stream()
                .filter(p->!p.isDeleted())
                .filter(p->p.getCategories().stream().anyMatch(c->!c.isDeleted()))
                .collect(Collectors.toList());;

        if (products.isEmpty()) {
            return;
        }

        int n = products.size() > OFFER_SCHEDULED_NUMBER_OF_PRODUCTS? OFFER_SCHEDULED_NUMBER_OF_PRODUCTS : products.size();

        Random rnd = new Random();
        List<Offer> offers = new ArrayList<>();
        for (int i = ZERO_NUMBER; i < n; i++) {
            Offer offer = new Offer();
            offer.setProduct(this.modelMapper.map(products.get(rnd.nextInt(products.size())), Product.class));
            offer.setPrice(offer.getProduct().getPrice().multiply(new BigDecimal(OFFER_SCHEDULED_DISCOUNT)));

            if (offers.stream().filter(o -> o.getProduct().getId().equals(offer.getProduct().getId())).count() == ZERO_NUMBER) {
                offers.add(offer);
            }
        }

        this.offerRepository.saveAll(offers);
    }
}
