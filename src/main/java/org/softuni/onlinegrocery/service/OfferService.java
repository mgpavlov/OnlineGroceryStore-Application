package org.softuni.onlinegrocery.service;

import org.softuni.onlinegrocery.domain.models.service.OfferServiceModel;

import java.util.List;

public interface OfferService {

    List<OfferServiceModel> findAllOffers();
}
