package com.ivoronline.springboot_database_jdbctemplate_update_bacth.controllers;

import com.ivoronline.springboot_database_jdbctemplate_update_bacth.dto.PersonDTO;
import com.ivoronline.springboot_database_jdbctemplate_update_bacth.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //=========================================================================================================
  // UPDATE
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/update")
  public int[] update() {
    int[]  updatedRecords = myService.update(createRecords());
    return updatedRecords;
  }

  //=========================================================================================================
  // UPDATE WITH BATCH SIZE
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/updateWithBatchSize")
  public int[][] updateWithBatchSize() {
    int[][] updatedRecords = myService.updateWithBatchSize(createRecords());
    return  updatedRecords;
  }

  //=========================================================================================================
  // CREATE RECORDS
  //=========================================================================================================
  public List<PersonDTO> createRecords() {

    //CREATE RECORDS TO INSERT
    PersonDTO       jack    = new PersonDTO(1, "John  New", 11);
    PersonDTO       jill    = new PersonDTO(2, "Bill  New", 22);
    PersonDTO       susan   = new PersonDTO(3, "Susan New", 33);

    //CREATE LIST
    List<PersonDTO> records = new ArrayList<>();
                    records.add(jack);
                    records.add(jill);
                    records.add(susan);

    //RETURN LIST
    return records;

  }
}

