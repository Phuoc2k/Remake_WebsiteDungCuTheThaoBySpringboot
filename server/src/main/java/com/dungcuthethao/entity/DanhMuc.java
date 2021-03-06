package com.dungcuthethao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DanhMuc")
public class DanhMuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(columnDefinition = "nvarchar(50)",name = "ten")
	private String ten;
	
	@Column(nullable = true,name = "danhMucCha")
	private Long danhMucCha;
	public DanhMuc(Long id, String ten, Long danhMucCha) {
		super();
		this.id = id;
		this.ten = ten;
		this.danhMucCha = danhMucCha;
	}
	public DanhMuc(String ten, Long danhMucCha) {
		super();
		this.ten = ten;
		this.danhMucCha = danhMucCha;
	}
	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Long getDanhMucCha() {
		return danhMucCha;
	}
	public void setDanhMucCha(Long danhMucCha) {
		this.danhMucCha = danhMucCha;
	}
	@Override
	public String toString() {
		return "DanhMuc [id=" + id + ", ten=" + ten + ", danhMucCha=" + danhMucCha + "]";
	}
	
}
