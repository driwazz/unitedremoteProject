package com.unitedremote.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unitedremote.springboot.entities.Authorities;

public interface AuthorityRepository extends JpaRepository<Authorities, Long>{

}
