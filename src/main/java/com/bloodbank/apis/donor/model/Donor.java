package com.bloodbank.apis.donor.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Donor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private int userId;
  private int quantity;
  private int hospitalId;
  private String bloodGroup;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate bloodCollectDate;


}
