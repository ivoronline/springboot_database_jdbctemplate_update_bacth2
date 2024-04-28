package com.ivoronline.springboot_database_jdbctemplate_update_bacth.service;

import com.ivoronline.springboot_database_jdbctemplate_update_bacth.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

  //=========================================================================================================
  // UPDATE
  //=========================================================================================================
  public int[] update(List<PersonDTO> records) {

    return jdbcTemplate.batchUpdate(

      "UPDATE PERSON SET NAME = ?, AGE = ? WHERE ID = ?",        //Order of parameters is used

      new BatchPreparedStatementSetter() {

        @Override
        public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
          preparedStatement.setString(1, records.get(i).getName());
          preparedStatement.setLong  (2, records.get(i).getAge ());
          preparedStatement.setLong  (3, records.get(i).getId  ());
        }

        @Override
        public int getBatchSize() {
          return records.size();
        }

      }

    );

  }

  //=========================================================================================================
  // UPDATE WITH BATCH SIZE
  //=========================================================================================================
  public int[][] updateWithBatchSize(List<PersonDTO> records) {

    return jdbcTemplate.batchUpdate(
      "UPDATE PERSON SET NAME = ?, AGE = ? WHERE ID = ?",
      records,
      2,    //Batch size
      (PreparedStatement preparedStatement, PersonDTO record) -> {
        preparedStatement.setString(1, record.getName());
        preparedStatement.setLong  (2, record.getAge ());
        preparedStatement.setLong  (3, record.getId  ());
      }
    );

  }

}
