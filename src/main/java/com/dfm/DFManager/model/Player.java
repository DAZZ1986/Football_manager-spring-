package com.dfm.DFManager.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstNameC;

    @Column(name = "last_name")
    private String lastNameC;

    @Column(name = "age")
    private int ageC;

    @Column(name = "position")
    private String positionC;

    @Column(name = "skill_lvl")
    private int skillLvlC;

    @Column(name = "talant")
    private int talantC;

    @Column(name = "number")
    private int numberC;

    @Column(name = "price")
    private int priceC;

    //@Column(name = "contract")
    //private int contractC;

    @Column(name = "salary")
    private int salaryC;

    @Column(name = "club")
    private String clubC;
}
