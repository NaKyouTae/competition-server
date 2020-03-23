package com.competition.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.dto.menu.MenuDto;
import com.competition.jpa.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	MenuDto findByIdx(String idx);
	
	List<Menu> findByParent(String parent, Sort sort);
}
