package com.user.dataservice.controller;

import com.user.dataservice.dto.DtosRes;
import com.user.dataservice.entity.DataTable;
import com.user.dataservice.service.DataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
@Slf4j
@AllArgsConstructor
public class DataController {

    private final DataService dataService;

    @GetMapping
    public ResponseEntity<List<DtosRes>> getData() {

        log.info("Getting data from database");
        List<DtosRes> dtosResList = dataService.getAllData();
        return ResponseEntity.status(200).body(dtosResList);
    }

    @PostMapping
    public ResponseEntity<DtosRes> addData(@RequestBody DataTable dataTable) {

        log.info("Adding data into database");
        DtosRes savedData = dataService.saveData(dataTable);
        return ResponseEntity.status(201).body(savedData);
    }

}
