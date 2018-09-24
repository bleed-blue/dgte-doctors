package com.ampota.gateway.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ampota.shared.client.CardClient;
import com.ampota.shared.dto.card.CardInfo;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/card")
public class CardGatewayResource {

    @Autowired
    private CardClient client;

    @GetMapping
    public ResponseEntity<Page<CardInfo>> rqlSearch(
            @RequestParam(required = false) @ApiParam(value = "The search term, example: name==test;deleted==false") String term,
            Pageable page) {
        return client.rqlSearch(term, page);
    }

}
