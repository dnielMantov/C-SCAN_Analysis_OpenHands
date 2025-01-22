package src.cscan;

import java.util.ArrayList;
import java.util.Collections;

public class CSCAN {

	public double run(int sectorSize, int tracks, int sectorsPerTrack, int transferRate, double seekTime, double rotationTime, int head, ArrayList<Integer> requests, boolean printSectors) {
		ArrayList<Integer> accessedSectors = new ArrayList<>();
		double transferTime = ((sectorSize * Math.pow(2, 10)) / (transferRate * Math.pow(2, 20))) * 1000;

		double totalSeekTime = 0;
		double totalRotationTime = 0;
		double totalTransferTime = 0;

		int oldHeadTrack = head / sectorsPerTrack;
		while (!requests.isEmpty()) {
			int headTrack = head / sectorsPerTrack;
			int nextSector = this.getNextRequestInCurrentTrack(head, sectorsPerTrack, requests, accessedSectors);

            if (nextSector != -1) {
                totalRotationTime += this.updateTotalRotationTime(head, nextSector, sectorsPerTrack, rotationTime);
                totalTransferTime += transferTime;
				head = nextSector;
                if (oldHeadTrack != headTrack) {
					totalSeekTime += seekTime;
					oldHeadTrack = headTrack;
				}
			} else {
				if (!requests.isEmpty() && headTrack < tracks - 1) {
					head += sectorsPerTrack;
				}
				else if (!requests.isEmpty() && headTrack == tracks - 1) {
					head = head - (headTrack * sectorsPerTrack);
					oldHeadTrack = -1;
				}
			}
		}
		if (printSectors)
			System.out.println("\nAccessed sectors:\n" + accessedSectors);
		return totalSeekTime + totalRotationTime + totalTransferTime;
	}

	private int getNextRequestInCurrentTrack(int head, int sectorsPerTrack, ArrayList<Integer> requests, ArrayList<Integer> accessedSectors) {
		ArrayList<Integer> sectorsInCurrentTrack = new ArrayList<>();
		for (Integer request : requests) {
			if ((request / sectorsPerTrack) == (head / sectorsPerTrack))
				sectorsInCurrentTrack.add(request);
		}
		if (sectorsInCurrentTrack.isEmpty())
			return  -1;

		sectorsInCurrentTrack.add(head);
		Collections.sort(sectorsInCurrentTrack);
		for (int i = 0; i < sectorsInCurrentTrack.size(); i++) {
			if (sectorsInCurrentTrack.get(i) == head) {
				Integer nextSector = (i + 1 > sectorsInCurrentTrack.size() - 1) ? sectorsInCurrentTrack.getFirst() : sectorsInCurrentTrack.get(i + 1);
				accessedSectors.add(nextSector);
				requests.remove(nextSector);
				return nextSector;
			}
		}
		return -1;
	}

	private double updateTotalRotationTime(int head, int nextSector, int sectorsPerTrack, double rotationTime) {
		if (head <= nextSector)
            return ((double) (nextSector - head) / sectorsPerTrack) * rotationTime;
		else
			return ((double) ((sectorsPerTrack - head % sectorsPerTrack) + nextSector % sectorsPerTrack) / sectorsPerTrack) * rotationTime;
	}

}
