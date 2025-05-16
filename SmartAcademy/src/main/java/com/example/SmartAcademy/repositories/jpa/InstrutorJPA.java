package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.InstrutorModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorJPA extends JpaRepository<InstrutorModels, Integer> {
}
