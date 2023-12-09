package com.jdbc_udemy.spring.springcore.properties;

import java.util.Properties;

public class CountriesAndLanguages {
	private  Properties CountryAndLangs;

	public Properties getCountryAndLangs() {
		return CountryAndLangs;
	}

	public void setCountryAndLangs(Properties countryAndLangs) {
		CountryAndLangs = countryAndLangs;
	}

	@Override
	public String toString() {
		return "CountriesAndLanguages [CountryAndLangs=" + CountryAndLangs + "]";
	}
	
}
