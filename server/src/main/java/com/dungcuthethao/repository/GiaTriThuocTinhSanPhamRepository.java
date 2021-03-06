package com.dungcuthethao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungcuthethao.entity.GiaTriThuocTinhSanPham;

public interface GiaTriThuocTinhSanPhamRepository extends JpaRepository<GiaTriThuocTinhSanPham, Long> {
	GiaTriThuocTinhSanPham findOneBySanphamIdAndThuoctinhsanphamId(Long idSP,Long idTT);
}
