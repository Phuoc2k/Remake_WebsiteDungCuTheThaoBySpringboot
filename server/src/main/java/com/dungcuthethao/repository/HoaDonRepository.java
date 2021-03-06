package com.dungcuthethao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dungcuthethao.entity.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

	List<HoaDon> findByTrangThaiIsFalse(Pageable pageable);
	List<HoaDon> findByTrangThaiIsTrue(Pageable pageable);
	
	List<HoaDon> findByTrangThaiIsTrueAndNguoiDungXacNhanIsFalse(Pageable pageable);
	List<HoaDon> findByTrangThaiIsTrueAndNguoiDungXacNhanIsTrue(Pageable pageable);

	List<HoaDon> findByNguoidungIdAndTrangThaiIsTrueAndNguoiDungXacNhanIsFalse(Long idND);
	List<HoaDon> findByNguoidungIdAndTrangThaiIsTrueAndNguoiDungXacNhanIsTrue(Long idND);
}
