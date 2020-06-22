package com.epam.bench.e07.version;

public class VersionStringScheme {

	public static void main(String[] args) {
		Runtime.Version version = Runtime.version();
		System.out.println("Current version is " + version);
		System.out.println("Major version number " + version.major());
		System.out.println("Minor version number " + version.minor());
		System.out.println("Security version number " + version.security());
		System.out.println("Pre-released information " + version.pre());
		System.out.println("Build Number " + version.build());
	}
}
