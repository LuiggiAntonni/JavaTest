package com.SigaBem.demo.repository;

import com.SigaBem.demo.model.entity.FreteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends CrudRepository<FreteEntity, Long> {

}
