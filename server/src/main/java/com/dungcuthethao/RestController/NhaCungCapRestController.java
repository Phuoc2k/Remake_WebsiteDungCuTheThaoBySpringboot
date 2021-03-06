package com.dungcuthethao.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dungcuthethao.entity.NhaCungCap;
import com.dungcuthethao.repository.NhaCungCapRepository;

@RestController
@RequestMapping("/nhacungcap")
public class NhaCungCapRestController {
	
	@Autowired
	private NhaCungCapRepository nhaCungCapRepository;
	
//	NhaCungCap saveNCC(NhaCungCap nhaCungCap);
//	void updateNCC(NhaCungCap nhaCungCap);
//	NhaCungCap findByTenNhaCungCap(String ten);
//	NhaCungCap findNCCByID(Long id);
//	List<NhaCungCap> findAll();
//	void deleteNCC(NhaCungCap nhaCungCap);
//	List<NhaCungCap> findAllAndPaging(Pageable pageable);
	
	@GetMapping
	public List<NhaCungCap> getAll() {
		return nhaCungCapRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public NhaCungCap getByID(@PathVariable Long id) {
		return nhaCungCapRepository.findById(id).get();
	}
	
	@GetMapping("/phantrang")
	public List<NhaCungCap> getAllAndPaging(@RequestParam int page,@RequestParam int limit) {
		Pageable pageable= PageRequest.of(page-1, limit);
		return nhaCungCapRepository.findAll(pageable).getContent();
	}
	@GetMapping("/tongso")
	public int getTotal() {
		return (int) nhaCungCapRepository.count();
	}
	@PostMapping
	public NhaCungCap addNCC(@RequestBody NhaCungCap nhaCungCap) {
		nhaCungCapRepository.save(nhaCungCap);
		return nhaCungCap;
	}
	@PutMapping
	public NhaCungCap updateNCC(@RequestBody NhaCungCap nhaCungCap) {
		nhaCungCapRepository.save(nhaCungCap);
		return nhaCungCap;
	}
	@DeleteMapping("/{id}")
	public void deletNCC(@PathVariable Long id) {
		nhaCungCapRepository.deleteById(id);
	}
	
	@GetMapping("/ten")
	public NhaCungCap getByTen(@RequestParam String ten) {
		return nhaCungCapRepository.findOneByTenNhaCungCap(ten);
	}
	
}
