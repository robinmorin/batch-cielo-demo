package com.example.batchcielodemo.repositories;

import com.example.batchcielodemo.entities.InfoProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoProcessRepository extends JpaRepository<InfoProcess, Integer> {
}
