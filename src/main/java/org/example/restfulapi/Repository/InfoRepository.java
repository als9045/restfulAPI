package org.example.restfulapi.Repository;

import org.example.restfulapi.Entiry.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface InfoRepository extends JpaRepository<Information, Long>{

}