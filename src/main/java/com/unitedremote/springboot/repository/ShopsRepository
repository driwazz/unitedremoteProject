package com.unitedremote.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unitedremote.springboot.entities.Shops;

public interface ShopsRepository extends JpaRepository<Shops, Long> {
	
	@Query("SELECT s FROM Shops s WHERE s.username = ?1 and s.liked = ?2")
	List<Shops> findAllShopsByUsers(String username, boolean lik);
	
	@Transactional
	@Modifying
	@Query("UPDATE Shops sh SET sh.liked = 1 WHERE sh.id  = ?1")
	public void likedShopRepo(Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Shops sh SET sh.liked = 0 WHERE sh.id  = ?1")
	public void dislikedShopRepo(Long id);
	

}
