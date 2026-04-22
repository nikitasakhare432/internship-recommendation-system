package com.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String role;

    @Column(length = 500)
    private String requiredSkills;

    private String location;
    private String domain;
    private String internshipType;
    private Double stipend;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getInternshipType() {
		return internshipType;
	}
	public void setInternshipType(String internshipType) {
		this.internshipType = internshipType;
	}
	public Double getStipend() {
		return stipend;
	}
	public void setStipend(Double stipend) {
		this.stipend = stipend;
	}
	@Override
	public String toString() {
		return "Internship [id=" + id + ", companyName=" + companyName + ", role=" + role + ", requiredSkills="
				+ requiredSkills + ", location=" + location + ", domain=" + domain + ", internshipType="
				+ internshipType + ", stipend=" + stipend + "]";
	}
}
