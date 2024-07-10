package com.JavaTestTask.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "file_data")
@Data
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
}
