package com.ivoronline.springboot_database_jdbctemplate_update_bacth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
  private Integer id;
  private String  name;
  private Integer age;
}
