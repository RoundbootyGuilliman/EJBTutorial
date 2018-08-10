package chapter3.validation.implementation;

import chapter3.validation.qualifier.USA;

@USA
public class ZipCodeChecker {
	
	boolean isZipCodeValid(String zip) {
		return zip.contains("5");
	}
}
