package com.dungcuthethao.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dungcuthethao.entity.ThuocTinhSanPham;
import com.dungcuthethao.repository.ThuocTinhSanPhamRepository;

@RestController
@RequestMapping("/thuoctinhsanpham")
public class ThuocTinhSanPhamRestController {
	@Autowired
	private ThuocTinhSanPhamRepository thuocTinhSanPhamRepository;
//	void saveTTSP(ThuocTinhSanPham thuocTinhSanPham);
//	void updateTTSP(ThuocTinhSanPham thuocTinhSanPham);
//	ThuocTinhSanPham findById(Long id);
//	ThuocTinhSanPham findOneByTenThuoctinh(String ten);
//	List<ThuocTinhSanPham> findAll();
	
	@GetMapping
	public List<ThuocTinhSanPham> getAll() {
		return thuocTinhSanPhamRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ThuocTinhSanPham getById(@PathVariable Long id) {
		return thuocTinhSanPhamRepository.findById(id).get();
	}
	@GetMapping("/ten")
	public ThuocTinhSanPham getByTen(@RequestParam String ten) {
		return thuocTinhSanPhamRepository.findOneByTenThuoctinh(ten);
	}
	@PostMapping
	public ThuocTinhSanPham addTTSP(@RequestBody ThuocTinhSanPham thuocTinhSanPham) {
		thuocTinhSanPhamRepository.save(thuocTinhSanPham);
		return thuocTinhSanPham;
	}
	@PutMapping
	public ThuocTinhSanPham updateTTSP(@RequestBody ThuocTinhSanPham thuocTinhSanPham) {
		thuocTinhSanPhamRepository.save(thuocTinhSanPham);
		return thuocTinhSanPham;
	}
	
	
}
