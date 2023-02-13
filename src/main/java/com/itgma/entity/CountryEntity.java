package com.itgma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country_details")
public class CountryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "country_capital")
	private String countryCapital;

	@Column(name = "country_region")
	private String countryRegion;

	@Column(name = "currency_code")
	private String defaultCurencyCode;

	@Column(name = "currency_name")
	private String defaultCurencyName;

	@Column(name = "currency_symbol")
	private String defaultCurencySymbol;

	@Column(name = "language_name")
	private String defaultLanguagesName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCapital() {
		return countryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

	public String getCountryRegion() {
		return countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public String getDefaultCurencyCode() {
		return defaultCurencyCode;
	}

	public void setDefaultCurencyCode(String defaultCurencyCode) {
		this.defaultCurencyCode = defaultCurencyCode;
	}

	public String getDefaultCurencyName() {
		return defaultCurencyName;
	}

	public void setDefaultCurencyName(String defaultCurencyName) {
		this.defaultCurencyName = defaultCurencyName;
	}

	public String getDefaultCurencySymbol() {
		return defaultCurencySymbol;
	}

	public void setDefaultCurencySymbol(String defaultCurencySymbol) {
		this.defaultCurencySymbol = defaultCurencySymbol;
	}

	public String getDefaultLanguagesName() {
		return defaultLanguagesName;
	}

	public void setDefaultLanguagesName(String defaultLanguagesName) {
		this.defaultLanguagesName = defaultLanguagesName;
	}

	@Override
	public String toString() {
		return "CountryEntity [id=" + id + ", countryName=" + countryName + ", countryCapital=" + countryCapital
				+ ", countryRegion=" + countryRegion + ", defaultCurencyCode=" + defaultCurencyCode
				+ ", defaultCurencyName=" + defaultCurencyName + ", defaultCurencySymbol=" + defaultCurencySymbol
				+ ", defaultLanguagesName=" + defaultLanguagesName + "]";
	}

}