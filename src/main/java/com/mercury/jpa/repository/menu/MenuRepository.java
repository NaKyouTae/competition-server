package com.mercury.jpa.repository.menu;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercury.jpa.model.menu.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	Menu findByIdx(String idx);
	
//	@Query(value="select idx, child, insertDate, level, menuGroup, menuOrder, parent, title, url, roleIdx, roleTitle from mercury_tb_menu where parent = 'null' order by menuOrder asc", nativeQuery = true)
	List<Menu> findByParentIsNullOrderByMenuOrderAsc();
	
	
	List<Menu> findByParent(String parent, Sort sort);
}


 