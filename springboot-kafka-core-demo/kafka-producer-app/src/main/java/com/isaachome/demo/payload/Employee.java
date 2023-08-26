package com.isaachome.demo.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Employee {

    private  String name;
    private  String email;
    private  String empCode;

}
