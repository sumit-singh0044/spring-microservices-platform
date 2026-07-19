package com.user.userinfo.controller;

import com.user.userinfo.entity.Address;
import com.user.userinfo.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public  AddressController(AddressService addressService)
    {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAddress(){
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Address>> getAddressesByUserId(
            @PathVariable Long userId) {

        return ResponseEntity.ok(addressService.getAddressesByUserId(userId));

    }

    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {

        Address savedAddress = addressService.saveAddress(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }



}
