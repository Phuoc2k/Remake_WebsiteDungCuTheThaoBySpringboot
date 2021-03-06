package com.dungcuthethao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ThuocTinhSanPham")
public class ThuocTinhSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(columnDefinition = "nvarchar(255)",name = "tenThuoctinh")
	private String tenThuoctinh;
	
	@OneToMany(mappedBy = "thuoctinhsanpham")
	@JsonIgnore
	private List<GiaTriThuocTinhSanPham> dsGiaTriThuocTinh = new ArrayList<GiaTriThuocTinhSanPham>();

	public ThuocTinhSanPham(Long id, String tenThuoctinh) {
		super();
		this.id = id;
		this.tenThuoctinh = tenThuoctinh;
	}

	public ThuocTinhSanPham(String tenThuoctinh) {
		super();
		this.tenThuoctinh = tenThuoctinh;
	}
	

	public ThuocTinhSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenThuoctinh() {
		return tenThuoctinh;
	}

	public void setTenThuoctinh(String tenThuoctinh) {
		this.tenThuoctinh = tenThuoctinh;
	}

	public List<GiaTriThuocTinhSanPham> getDsGiaTriThuocTinh() {
		return dsGiaTriThuocTinh;
	}

	public void setDsGiaTriThuocTinh(List<GiaTriThuocTinhSanPham> dsGiaTriThuocTinh) {
		this.dsGiaTriThuocTinh = dsGiaTriThuocTinh;
	}

	@Override
	public String toString() {
		return "ThuocTinhSanPham [id=" + id + ", tenThuoctinh=" + tenThuoctinh + "]";
	}

	
	
	
	
}
