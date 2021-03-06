package com.ampota.card.resource;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ampota.card.service.collection.BundleService;
import com.ampota.shared.dto.card.collection.BundleInfo;

import xyz.xpay.shared.web.BaseResource;

@RestController
@RequestMapping("/api/bundle")
public class BundleResource extends BaseResource<BundleInfo, BundleService> {

    @PostMapping
    public ResponseEntity<BundleInfo> save(Principal principal, @RequestBody BundleInfo bundle) {
        String username = principal.getName();
        bundle.setOwner(username);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.saveInfo(bundle));
    }

}
