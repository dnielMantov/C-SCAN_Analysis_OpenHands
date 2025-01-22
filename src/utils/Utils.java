package src.utils;

import java.util.ArrayList;
import java.util.Random;

public class Utils {

	public static ArrayList<Integer> getRandomRequests(int base, int bounds, int number) {
		Random random = new Random();
		ArrayList<Integer> requests = new ArrayList<>();
		while (requests.size() < number)
			requests.add(random.nextInt(base, bounds + 1));
		return requests;
	}

	public static int getRandomInitialSector(int base, int bounds) {
		Random random = new Random();
		return random.nextInt(base, bounds + 1);
	}

}
