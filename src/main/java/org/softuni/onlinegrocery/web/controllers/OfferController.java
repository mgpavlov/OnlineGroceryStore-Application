package org.softuni.onlinegrocery.web.controllers;

import org.modelmapper.ModelMapper;

import org.softuni.onlinegrocery.domain.models.service.OfferServiceModel;
import org.softuni.onlinegrocery.domain.models.view.OfferViewModel;
import org.softuni.onlinegrocery.service.OfferService;
import org.softuni.onlinegrocery.web.annotations.PageTitle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

import static org.softuni.onlinegrocery.util.constants.AppConstants.*;

@Controller
public class OfferController extends BaseController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/sales")
    @PreAuthorize("isAuthenticated()")
    @PageTitle(SALES)
    public ModelAndView topOffers(ModelAndView modelAndView) {

        return view("offer/sales", modelAndView);
    }

    @GetMapping("/fetch/sales/{category}")
    @ResponseBody
    public List<OfferViewModel> fetchByCategory(@PathVariable String category) {

        List<OfferViewModel> offerViewModels = mapOfferServiceToViewModel(this.offerService.findAllOffers());

        return offerViewModels;
    }

    private List<OfferViewModel> mapOfferServiceToViewModel(List<OfferServiceModel> offerServiceModel){
        return offerServiceModel.stream()
                .map(product -> modelMapper.map(product, OfferViewModel.class))
                .collect(Collectors.toList());
    }
}
