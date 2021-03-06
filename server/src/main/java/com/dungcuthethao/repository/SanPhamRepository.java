package com.dungcuthethao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dungcuthethao.entity.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
	List<SanPham> findByDanhmucIdAndTrangThaiIsTrue(Long idDM,Pageable pageable);
	List<SanPham> findByDanhmucIdAndTrangThaiIsTrueOrderByGiaAsc(Long idDM,Pageable pageable);
	List<SanPham> findByDanhmucIdAndTrangThaiIsTrueOrderByGiaDesc(Long idDM,Pageable pageable);
	@Query(value = "SELECT TOP 10 *  FROM SANPHAM order by soLuotXem DESC", nativeQuery = true)
	List<SanPham> findDSSanPhamNoiBat();
		
	@Query(value = "SELECT TOP 3 *  FROM SANPHAM order by soLuotXem DESC", nativeQuery = true)
	List<SanPham> findTop3SanPhamBySoLuotXem();
	
	@Query(value = " SELECT TOP 3 *  FROM SANPHAM order by phanTramGiamGia desc", nativeQuery = true)
	List<SanPham> findTop3SanPhamGiamGiaNhieuNhat();
	
	List<SanPham> findByTenContainingAndTrangThaiIsTrue(String ten,Pageable pageable);
	List<SanPham> findByTenContainingAndTrangThaiIsTrueOrderByGiaAsc(String ten,Pageable pageable);
	List<SanPham> findByTenContainingAndTrangThaiIsTrueOrderByGiaDesc(String ten,Pageable pageable);
	List<SanPham> findByOrderByGiaAsc(Pageable pageable);
	List<SanPham> findByOrderByGiaDesc(Pageable pageable);
	
}
