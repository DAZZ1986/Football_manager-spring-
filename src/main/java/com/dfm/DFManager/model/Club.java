package com.dfm.DFManager.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "reputation")
    private int reputation;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "transfer_budget")
    private Long transferBudget;

    @Column(name = "nation")
    private String nation;

    @Column(name = "stadium_capacity")
    private int stadiumCapacity;

    @Column(name = "division")
    private String division;
}
