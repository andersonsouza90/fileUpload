package com.JavaTestTask.repository;

import com.JavaTestTask.model.FileDataDto;
import com.JavaTestTask.model.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long> {

    @Query("SELECT f FROM FileData f WHERE f.name LIKE %:search% OR f.phone LIKE %:search%")
    List<FileData> findByNameOrPhone(String search);
}
