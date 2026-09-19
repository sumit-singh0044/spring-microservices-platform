package com.user.dataservice.service;

import com.user.dataservice.dto.DtosRes;
import com.user.dataservice.entity.DataTable;
import com.user.dataservice.exception.DataAlreadyExistException;
import com.user.dataservice.repository.DataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DataService {

    private final DataRepository dataRepository;

    public List<DtosRes> getAllData() {

        log.info("Fetching all data from the database");
        List<DtosRes> dtosResList = new ArrayList<>();
        List<DataTable> dataTableList = dataRepository.findAll();
        for (DataTable dataTable : dataTableList) {
            DtosRes dtosRes = new DtosRes();
            dtosRes.setId(dataTable.getId());
            dtosRes.setName(dataTable.getName());
            dtosRes.setPhone_number(dataTable.getPhonenumber());
            dtosRes.setDescription(dataTable.getDescription());
            dtosRes.setCreatedBy(dataTable.getCreatedBy());
            dtosResList.add(dtosRes);
        }
        log.info("Retrieved {} data entries", dtosResList.size());
        return dtosResList;
    }

    public DtosRes saveData(DataTable dataTable) {

        log.info("Saving data into the database");
        if (dataRepository
                .findByPhonenumber(dataTable.getPhonenumber())
                .isPresent()) {

            log.error("Data with phone number {} already exists", dataTable.getPhonenumber());
            throw new DataAlreadyExistException(
                    "Data with phone number "
                            + dataTable.getPhonenumber()
                            + " already exists"
            );
        }

        DataTable savedData = dataRepository.save(dataTable);
        DtosRes dtosRes = new DtosRes(
                savedData.getId(),
                savedData.getName(),
                savedData.getPhonenumber(),
                savedData.getDescription(),
                savedData.getCreatedBy()
        );
        log.info("Saved data into the database");

        return dtosRes;
    }
}
