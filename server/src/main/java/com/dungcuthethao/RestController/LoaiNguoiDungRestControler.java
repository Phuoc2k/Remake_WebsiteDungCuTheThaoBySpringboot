package com.dungcuthethao.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dungcuthethao.entity.LoaiNguoiDung;
import com.dungcuthethao.repository.LoaiNguoiDungRepository;

@RestController
@RequestMapping("/loainguoidung")
public class LoaiNguoiDungRestControler {
	@Autowired
	private LoaiNguoiDungRepository loaiNguoiDungRepository;
	
//	LoaiNguoiDung findByID(Long id);
//	LoaiNguoiDung findByTenLoaiNguoiDung(String tenLoai);
	
	@GetMapping("/{id}")
	public LoaiNguoiDung getById(@PathVariable Long id) {
		return loaiNguoiDungRepository.findById(id).get();
	}
	
	@GetMapping("/ten")
	public LoaiNguoiDung getByTen(@RequestParam String ten) {
		return loaiNguoiDungRepository.findOneByTenLoai(ten);
	}
}
