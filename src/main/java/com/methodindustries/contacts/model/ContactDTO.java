package com.methodindustries.contacts.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContactDTO {

    String firstName;
    String lastName;
    Date startDate;
    Gender gender;
}
