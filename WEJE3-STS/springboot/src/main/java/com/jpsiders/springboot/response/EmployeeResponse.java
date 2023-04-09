package com.jpsiders.springboot.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpsiders.springboot.pojo.EmployeePOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
	
	private String status;
	private String msg;
	private EmployeePOJO data;
	private List<EmployeePOJO> list;

}
