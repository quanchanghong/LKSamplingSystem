package cn.com.lk.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * π‹¿Ì‘±
 * @author 1500000367-3
 *
 */
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adminId;
	private String role;
	private String adminName;
	private String adminPWD;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPWD() {
		return adminPWD;
	}
	public void setAdminPWD(String adminPWD) {
		this.adminPWD = adminPWD;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", role=" + role + ", adminName="
				+ adminName + ", adminPWD=" + adminPWD + "]";
	}
	
}
