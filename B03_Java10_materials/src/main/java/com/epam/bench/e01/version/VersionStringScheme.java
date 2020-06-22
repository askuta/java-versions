package com.epam.bench.e01.version;

public class VersionStringScheme {

	public static void main(String[] args) {
		Runtime.Version version = Runtime.version();
		System.out.println("Current version is " + version);
		System.out.println("Feature version number " + version.feature());
		System.out.println("Interim version number " + version.interim());
		System.out.println("Update version number " + version.update());
		System.out.println("Patch version number " + version.patch());
		System.out.println("Pre-released information " + version.pre());
		System.out.println("Build Number " + version.build());
	}
}
