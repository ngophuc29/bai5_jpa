package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="dienthoai")
public class dienthoai {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDT;
	
	@Column(name ="tendt")
	@NotEmpty(message = "tendt k dung de trong")
	@NotNull(message = "tendt k dung de trong")
	private String tendt;
	
	
	@Column(name ="namsx")
	private int namsx;
	
	
	@Column(name ="cauhinh")
	@NotEmpty(message = "cauhinh k dung de trong")
	@NotNull(message = "cauhinh k dung de trong")
	private String cauhinh;
	
	@ManyToOne
	@JoinColumn(name="mancc" ,referencedColumnName = "mancc",nullable =  false)
	private nhacungcap nhacungcap;

	public dienthoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public dienthoai(int maDT,
			@NotEmpty(message = "tendt k dung de trong") @NotNull(message = "tendt k dung de trong") String tendt,
			@NotEmpty(message = "namsx k dung de trong") int namsx,
			@NotEmpty(message = "cauhinh k dung de trong") @NotNull(message = "cauhinh k dung de trong") String cauhinh,
			models.nhacungcap nhacungcap) {
		super();
		this.maDT = maDT;
		this.tendt = tendt;
		this.namsx = namsx;
		this.cauhinh = cauhinh;
		this.nhacungcap = nhacungcap;
	}

	public dienthoai(
			@NotEmpty(message = "tendt k dung de trong") @NotNull(message = "tendt k dung de trong") String tendt,
			@NotEmpty(message = "namsx k dung de trong") int namsx,
			@NotEmpty(message = "cauhinh k dung de trong") @NotNull(message = "cauhinh k dung de trong") String cauhinh,
			models.nhacungcap nhacungcap) {
		super();
		this.tendt = tendt;
		this.namsx = namsx;
		this.cauhinh = cauhinh;
		this.nhacungcap = nhacungcap;
	}

	public int getMaDT() {
		return maDT;
	}

	public void setMaDT(int maDT) {
		this.maDT = maDT;
	}

	public String getTendt() {
		return tendt;
	}

	public void setTendt(String tendt) {
		this.tendt = tendt;
	}

	public int getNamsx() {
		return namsx;
	}

	public void setNamsx(int namsx) {
		this.namsx = namsx;
	}

	public String getCauhinh() {
		return cauhinh;
	}

	public void setCauhinh(String cauhinh) {
		this.cauhinh = cauhinh;
	}

	public nhacungcap getNhacungcap() {
		return nhacungcap;
	}

	public void setNhacungcap(nhacungcap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}

	@Override
	public String toString() {
		return "dienthoai [maDT=" + maDT + ", tendt=" + tendt + ", namsx=" + namsx + ", cauhinh=" + cauhinh
				+ ", nhacungcap=" + nhacungcap + "]";
	}
	
	 
	
	
}
