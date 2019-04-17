package com.github.daanielowsky.FinalProject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true, nullable = false)
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
