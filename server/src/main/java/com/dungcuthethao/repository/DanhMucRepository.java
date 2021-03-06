package com.dungcuthethao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungcuthethao.entity.DanhMuc;

public interface DanhMucRepository extends JpaRepository<DanhMuc, Long> {
	DanhMuc findOneByTen(String ten);
	List<DanhMuc> findByDanhMucCha(Long idDanhMucCha);
	List<DanhMuc> findByDanhMucChaNull();
	List<DanhMuc> findByDanhMucChaNotNull();
}
