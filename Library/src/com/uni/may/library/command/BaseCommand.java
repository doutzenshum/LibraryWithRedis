package com.uni.may.library.command;

import com.uni.may.library.equipment.Library;

public class BaseCommand {

	public static final ThreadLocal<Context> THREAD_CONTEXT = new ThreadLocal<>();

	public static void execute(String command, String[] params) {
		Context cntxt = THREAD_CONTEXT.get();
		if (cntxt == null) {
			cntxt = new Context();
			THREAD_CONTEXT.set(cntxt);
		}
		if (cntxt.getEqu() == null) {
			cntxt.setEqu(Library.getInstance());
		}

		String rs = null;
		switch (command) {
		case "ls":
			rs = cntxt.getEqu().ls();
			System.out.println(rs);
			break;
		case "cd":
			rs = cntxt.getEqu().cd(params == null ? null : params[0]);
			System.out.println(rs);
		default:
			break;
		}
	}

}
