package com.dungcuthethao.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dungcuthethao.entity.SanPham;
import com.dungcuthethao.repository.SanPhamRepository;

@RestController
@RequestMapping("/sanpham")
public class SanPhamRestController {
	@Autowired
	private SanPhamRepository sanPhamRepository;

	@GetMapping
	public List<SanPham> getAll() {
		return sanPhamRepository.findAll();
	}
	@GetMapping("/phantrang")
	public List<SanPham> getAllAndPaging(@RequestParam int page,@RequestParam int limit) {
		Pageable pageable= PageRequest.of(page-1, limit);
		return sanPhamRepository.findAll(pageable).getContent();
	}
	@GetMapping("/phantrang/sapxep/tang")
	public List<SanPham> getAllAndPagingAndSapXepTang(@RequestParam int page,@RequestParam int limit) {
		Pageable pageable= PageRequest.of(page-1, limit);
		return sanPhamRepository.findByOrderByGiaAsc(pageable);
	}
	@GetMapping("/phantrang/sapxep/giam")
	public List<SanPham> getAllAndPagingAndSapXepGiam(@RequestParam int page,@RequestParam int limit) {
		Pageable pageable= PageRequest.of(page-1, limit);
		return sanPhamRepository.findByOrderByGiaDesc(pageable);
	}
	@GetMapping("/tongso")
	public Long getTotal() {
		return (Long) sanPhamRepository.count();
	}
	@GetMapping("/{id}")
	public SanPham getByID(@PathVariable Long id) {
		return sanPhamRepository.findById(id).get();
	}
	@PostMapping
	public SanPham addSP(@RequestBody SanPham  sanPham) {
		sanPhamRepository.save(sanPham);
		return sanPham;
	}
	@PutMapping
	public SanPham updateSP(@RequestBody SanPham  sanPham) {
		sanPhamRepository.save(sanPham);
		return sanPham;
	}
	@GetMapping("/top3soluotxem")
	public List<SanPham> getTop3SoLuotXem() {
		return sanPhamRepository.findTop3SanPhamBySoLuotXem();
	}
	
	@GetMapping("/top3sanphangiamgia")
	public List<SanPham> getTop3GiamGia() {
		return sanPhamRepository.findTop3SanPhamGiamGiaNhieuNhat();
	}
	
	@GetMapping("/top10noibat")
	public List<SanPham> getDSNoiBat() {
		return sanPhamRepository.findDSSanPhamNoiBat();
	}
	
	@GetMapping("/search")
	public List<SanPham> searchByTen(@RequestParam String ten,@RequestParam int page,@RequestParam int limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		return sanPhamRepository.findByTenContainingAndTrangThaiIsTrue(ten, pageable);
		
	}
	@GetMapping("/search/sapxep/tang")
	public List<SanPham> searchByTenAndSapXepTang(@RequestParam String ten,@RequestParam int page,@RequestParam int limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		return sanPhamRepository.findByTenContainingAndTrangThaiIsTrueOrderByGiaAsc(ten, pageable);
		
	}
	@GetMapping("/search/sapxep/giam")
	public List<SanPham> searchByTenAndSapXepGiam(@RequestParam String ten,@RequestParam int page,@RequestParam int limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		return sanPhamRepository.findByTenContainingAndTrangThaiIsTrueOrderByGiaDesc(ten, pageable);
		
	}
	@GetMapping("/danhmuc/{idDM}")
	public List<SanPham> getByDanhMuc(@PathVariable Long idDM,@RequestParam int page,@RequestParam int limit) {
		Pageable pageable= PageRequest.of(page-1, limit);
		return sanPhamRepository.findByDanhmucIdAndTrangThaiIsTrue(idDM, pageable);
	}
	@GetMapping("/danhmuc/{idDM}/tang")
	public List<SanPham> getByDanhMucTang(@PathVariable Long idDM,@RequestParam int page,@RequestParam int limit) {
		Pageable pageable= PageRequest.of(page-1, limit);
		return sanPhamRepository.findByDanhmucIdAndTrangThaiIsTrueOrderByGiaAsc(idDM, pageable);
	}
	@GetMapping("/danhmuc/{idDM}/giam")
	public List<SanPham> getByDanhMucGiam(@PathVariable Long idDM,@RequestParam int page,@RequestParam int limit) {
		Pageable pageable= PageRequest.of(page-1, limit);
		return sanPhamRepository.findByDanhmucIdAndTrangThaiIsTrueOrderByGiaDesc(idDM, pageable);
	}
	
	
	
}
