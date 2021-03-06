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

import com.dungcuthethao.entity.DanhMuc;
import com.dungcuthethao.repository.DanhMucRepository;

@RestController
@RequestMapping("/danhmuc")
public class DanhMucRestController {
	@Autowired
	private DanhMucRepository danhMucRepository;
	
	
//	List<DanhMuc> findAll();
//	DanhMuc findByTen(String ten);
//	List<DanhMuc> findAllDanhMucConById(Long id);
//	List<DanhMuc> findAllDanhMucCha();
//	void updateDanhMuc(DanhMuc danhMuc);
//	void themDanhMuc(DanhMuc danhMuc);
//	List<DanhMuc> findAllAndPaging(Pageable pageable);
//	DanhMuc findOne(Long id);
//	List<DanhMuc> findAllDanhMucCon();
	
	@GetMapping
	public List<DanhMuc> getAll() {
		return danhMucRepository.findAll();
	}
	
	@GetMapping("/ten")
	public DanhMuc getByTen(@RequestParam String ten) {
		return danhMucRepository.findOneByTen(ten);
	}
	@GetMapping("/{id}")
	public DanhMuc getByTen(@PathVariable Long id) {
		return danhMucRepository.findById(id).get();
	}
	
	@GetMapping("/danhmuccha/{idDanhMucCha}")
	public List<DanhMuc> getByDanhMucCha(@PathVariable Long idDanhMucCha) {
		return danhMucRepository.findByDanhMucCha(idDanhMucCha);
	}
	
	@GetMapping("/danhmuccha")
	public List<DanhMuc> getAllDanhMucCha() {
		return danhMucRepository.findByDanhMucChaNull();
	}
	
	@GetMapping("/phantrang")
	public List<DanhMuc> getPhanTrang(@RequestParam int page, @RequestParam int limit){
		Pageable pageable= PageRequest.of(page-1, limit);
		return danhMucRepository.findAll(pageable).getContent();
		
	}
	@GetMapping("/tongso")
	public int getTotal() {
		return (int) danhMucRepository.count();
	}
	@GetMapping("/danhmuccon")
	public List<DanhMuc> getAllDanhMucCon() {
		return danhMucRepository.findByDanhMucChaNotNull();
	}
	
	@PostMapping
	public DanhMuc addDanhMuc(@RequestBody DanhMuc danhMuc) {
		danhMucRepository.save(danhMuc);
		return danhMuc;
	}
	
	@PutMapping
	public DanhMuc updateDanhMuc(@RequestBody DanhMuc danhMuc) {
		danhMucRepository.save(danhMuc);
		return danhMuc;
	}
	
}
