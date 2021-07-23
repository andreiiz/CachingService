package it.unibo.chachingservice.utils;

public class Utils {
	
	private static final long MEGABYTE = 1024L * 1024L;

	private Utils() {}
	
	public static long bytesToMb(long bytes) {
		return bytes / MEGABYTE;
	}
	public static long mbToBytes(long mb) {
		return mb * MEGABYTE;
	}
}
