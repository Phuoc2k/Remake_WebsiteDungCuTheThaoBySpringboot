package com.dungcuthethao.client.entity;

public class ChiTietHoaDon {
	private SanPham sanpham;
	
	private HoaDon hoadon;
	
	private int soLuong;
	public ChiTietHoaDon(SanPham sanpham, HoaDon hoadon, int soLuong) {
		super();
		this.sanpham = sanpham;
		this.hoadon = hoadon;
		this.soLuong = soLuong;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public HoaDon getHoadon() {
		return hoadon;
	}
	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [sanpham=" + sanpham + ", hoadon=" + hoadon  + ", soLuong="
				+ soLuong + "]";
	}
	
	
	
}
