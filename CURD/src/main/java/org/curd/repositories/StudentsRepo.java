package org.curd.repositories;


import org.curd.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentsRepo extends JpaRepository<Students, Integer>{

}
