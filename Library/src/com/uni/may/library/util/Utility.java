package com.uni.may.library.util;

public abstract class Utility {

	public static String combineLsResult(String rs, Object[] objs) {

		if (objs != null) {
			for (int i = 0; i < objs.length; i++) {
				rs = rs + objs[i] + "\t";

				if (i % 5 == 4) {
					rs = rs + "\n";
				}
			}
		}

		return rs;
	}

}
