package com.scarf.loadbalancer;

import java.util.ArrayList;
import java.util.Random;

public class App {
	ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		App app = new App();
		app.doWork(args);
	}

	public String doWork(String[] input) {

		if (input == null || input.length == 0) {
			return "Please pass in a valid value";
		}

		Random rand = new Random();
		int sum = 0; // Sum of the sizes of all the servers passed in

		/*
		 * Holds an array for each server. Each array holds the name of the
		 * server and its size.
		 */
		ArrayList<String[]> serverList = new ArrayList<String[]>();

		for (String s : input) {

			String tokens[] = s.split(":");
			serverList.add(tokens);
			sum += Integer.parseInt(tokens[1]);
		}
		if (sum == 0) {
			return "No server space available";
		}

		// random integer from 0 to (sum -1)inclusive
		int serverChosen = rand.nextInt(sum);

		// for one server of size n, rangeMin would be 0 and rangeMax would be
		// n-1
		int rangeMin = 0;

		int rangeMax = 0;

		/*
		 * For an imaginary set of numbers from 0 to sum-1, each server is
		 * assigned to a range in this set. The size of the range assigned to
		 * each server is equal to the size of the server. The ranges for the
		 * server are allocated using the order in which the servers are passed
		 * in. A larger server has a larger range, so when a random integer is
		 * chosen, the integer is more likely to fall within the larger range.
		 * The name of the server associated with the range that
		 * serverChosenfalls within is returned. If serverChosen is within 0 to
		 * (the size of the first server - 1), the first server is chosen
		 */
		for (int i = 0; i < serverList.size(); i++) {
			// Size of this server.
			int serverSize = Integer.parseInt(serverList.get(i)[1]);

			/*
			 * The highest value to be included in the range for this server. -1
			 * for indexing at 0
			 */
			rangeMax = serverSize + rangeMin - 1;

			if (serverChosen <= rangeMax) {
				/*
				 * serverChosen is within the range of current server, so return
				 * the current server.
				 */
				return serverList.get(i)[0];
			}

			/*
			 * The bottom of the range for the next server is 1 + the top of the
			 * range for this one.
			 */
			rangeMin = rangeMax + 1;
		}

		return serverList.get(serverList.size() - 1)[0];

	}
}
