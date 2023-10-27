package com.dfm.DFManager.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity                 //эта аннотация говорит что данная сущность связана с БД
@Table(name = "user")   //тут описываем как эта сущность связана с БД
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")    //тут прописываю имя колонки в БД
    private String firstNameAAA;

    @Column(name = "last_name")    //тут прописываю имя колонки в БД
    private String lastNameDDD;


}
