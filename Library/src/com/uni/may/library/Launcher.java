package com.uni.may.library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.uni.may.library.command.BaseCommand;

public class Launcher {

	public static void main(String[] args) throws Exception {

		String command = null;
		String[] params = null;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

		String line = null;

		while (!"exit".equals(line = reader.readLine())) {

			if (null == line) {
				continue;
			}
			String[] elems = line.split(" ");

			command = elems[0];

			if (elems.length > 1) {
				params = Arrays.copyOfRange(elems, 1, elems.length);
			}

			BaseCommand.execute(command, params);
		}

	}

}
