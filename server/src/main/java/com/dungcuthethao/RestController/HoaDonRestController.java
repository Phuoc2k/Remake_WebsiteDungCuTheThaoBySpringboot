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

import com.dungcuthethao.entity.HoaDon;
import com.dungcuthethao.repository.HoaDonRepository;

@RestController
@RequestMapping("/hoadon")
public class HoaDonRestController {

	@Autowired
	private HoaDonRepository  hoaDonRepository;

	
	@GetMapping("/trangthai/dagiao")
	public List<HoaDon> getTrangThaiTrue(@RequestParam int page, @RequestParam int limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		return hoaDonRepository.findByTrangThaiIsTrue(pageable);
	}
	@GetMapping("/trangthai/chuagiao")
	public List<HoaDon> getTrangThaiFalse(@RequestParam int page, @RequestParam int limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		return hoaDonRepository.findByTrangThaiIsFalse(pageable);
	}
	@GetMapping("/nguoidung/danhan/{idND}")
	public List<HoaDon> getByNguoiDungNhan(@PathVariable Long idND) {
		return hoaDonRepository.findByNguoidungIdAndTrangThaiIsTrueAndNguoiDungXacNhanIsTrue(idND);
	}
	@GetMapping("/nguoidung/chuanhan/{idND}")
	public List<HoaDon> getByNguoiDungChuaNhan(@PathVariable Long idND) {
		return hoaDonRepository.findByNguoidungIdAndTrangThaiIsTrueAndNguoiDungXacNhanIsFalse(idND);
	}
	
	@GetMapping
	public List<HoaDon> getALL() {
		return hoaDonRepository.findAll();
		
	}
	
	
	@GetMapping("/{id}")
	public HoaDon findById(@PathVariable Long id) {
		return hoaDonRepository.findById(id).get();
		
	}
	@PostMapping
	public HoaDon addHD(@RequestBody HoaDon hoaDon) {
		hoaDonRepository.save(hoaDon);
		return hoaDon;
	}
	@PutMapping
	public HoaDon updateHD(@RequestBody HoaDon hoaDon) {
		hoaDonRepository.save(hoaDon);
		return hoaDon;
	}
	@DeleteMapping("/{id}")
	public void deleteHoaDon(@PathVariable Long id) {
		hoaDonRepository.deleteById(id);
	}
}
