package models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="nhacungcap")
public class nhacungcap {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mancc;
	
	
	@NotEmpty(message = "ten ncc k dung de trong")
	@NotNull(message = "ten ncc k dung de trong")
	@Size(min = 4,max =10,message = "ten dien thoai tu 4 den 10 ki tu")
	private String tenncc;
	
	
	@NotEmpty(message = "diachi k dung de trong")
	@NotNull(message = "diachi k dung de trong")
	private String diachi;
	
	
	@NotEmpty(message = "sodienthoai k dung de trong")
	@NotNull(message = "sodienthoai k dung de trong")
	private String sodienthoai;

	
	@OneToMany(mappedBy = "nhacungcap" ,cascade = CascadeType.ALL)
	private List<dienthoai>dienthoai;

	public nhacungcap() {
		super();
		// TODO Auto-generated constructor stub
	}


	public nhacungcap(int mancc,
			@NotEmpty(message = "ten ncc k dung de trong") @NotNull(message = "ten ncc k dung de trong") @Size(min = 4, max = 10, message = "ten dien thoai tu 4 den 10 ki tu") String tenncc,
			@NotEmpty(message = "diachi k dung de trong") @NotNull(message = "diachi k dung de trong") String diachi,
			@NotEmpty(message = "sodienthoai k dung de trong") @NotNull(message = "sodienthoai k dung de trong") String sodienthoai) {
		super();
		this.mancc = mancc;
		this.tenncc = tenncc;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
	}


	public nhacungcap(
			@NotEmpty(message = "ten ncc k dung de trong") @NotNull(message = "ten ncc k dung de trong") @Size(min = 4, max = 10, message = "ten dien thoai tu 4 den 10 ki tu") String tenncc,
			@NotEmpty(message = "diachi k dung de trong") @NotNull(message = "diachi k dung de trong") String diachi,
			@NotEmpty(message = "sodienthoai k dung de trong") @NotNull(message = "sodienthoai k dung de trong") String sodienthoai) {
		super();
		this.tenncc = tenncc;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
	}


	public int getMancc() {
		return mancc;
	}


	public void setMancc(int mancc) {
		this.mancc = mancc;
	}


	public String getTenncc() {
		return tenncc;
	}


	public void setTenncc(String tenncc) {
		this.tenncc = tenncc;
	}


	public String getDiachi() {
		return diachi;
	}


	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}


	public String getSodienthoai() {
		return sodienthoai;
	}


	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}


	@Override
	public String toString() {
		return "nhacungcap [mancc=" + mancc + ", tenncc=" + tenncc + ", diachi=" + diachi + ", sodienthoai="
				+ sodienthoai + "]";
	}
	
	
	
}
