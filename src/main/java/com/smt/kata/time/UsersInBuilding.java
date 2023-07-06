package com.smt.kata.time;

import java.util.ArrayList;
// JDK 11.x
import java.util.Date;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: UsersInBuilding.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Users In Building
 * You are given a list of data entries that represent entries and exits of groups 
 * of people into a building. An entry looks like this:
 * 
 * {"date": 1526579928, count: 3, "type": "enter"}
 * 
 * This means 3 people entered the building. An exit looks like this:
 * 
 * {"date": 1526580382, count: 2, "type": "exit"}
 * 
 * This means that 2 people exited the building. date is in entry time.
 * 
 * Find the busiest period in the building, that is, the time with the most people 
 * in the building. Return it as response object (start, end, count). You can assume 
 * the building always starts off and ends up empty, i.e. with 0 people inside.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
public class UsersInBuilding {

	protected enum EntryType { ENTER, EXIT }
	
	// Data structure to hold entries.
	List<Entry> entries = new ArrayList<>();
		
	/**
	 * Initializes the counts and transactions
	 */
	public UsersInBuilding() {
		super();
	}

	/**
	 * Adds an entry of users entering or exiting the 
	 * @param entryTime Time of the transaction
	 * @param count Number of people 
	 * @param type Entering or exiting the building
	 */
	public void addEntry(Date entryTime, int count, EntryType type) {
		// Create a new Entry object and add it to the list of entries.
		entries.add(new Entry(entryTime, count, type));
	}
	
	/**
	 * Calculates the busy period for the day
	 * @return
	 */
	public Response getBusyPeriod() {
		// Keep track of the current and max occupancy and time frames.
		Date beg = null;
		Date end = null;
		int occupancy = 0;
		
		Date maxBeg = null;
		Date maxEnd = null;
		int maxOccupancy = 0;
		
		// Iterate the list of all entries updating the time window and building occupancy
		for (int i = 0; i < entries.size(); i++) {
			Entry entry = entries.get(i);
			
			// For initial entry set the time window and count.
			// Assuming initial entry is always ENTER type.
			if (i == 0) { 
				beg = entry.getEntryTime();
				System.out.println(beg);
				end = entries.get(i + 1).getEntryTime();
				System.out.println(end);
				occupancy = entry.getCount();
				 
				maxBeg = entry.getEntryTime();
				maxEnd = entries.get(i + 1).getEntryTime();
				maxOccupancy = entry.getCount();
			}
			
			// Update the current time window and occupancy.
			// If the current occupancy is higher than the max, update the max
			else {
				System.out.println(i);
				beg = end; 
				System.out.println(beg);
				end = entry.getEntryTime();
				System.out.println(end);
				if (entry.getType() == EntryType.ENTER) {
					occupancy += entry.getCount();
				}
				else {
					occupancy -= entry.getCount();
				}
				 
				// Check to see if more people entering is a new max occupancy:
				if (occupancy > maxOccupancy) {
					maxOccupancy = occupancy;
					maxBeg = beg;
					maxEnd = end;
				}
			}
			
		}
		
		return new Response(maxBeg, maxEnd, maxOccupancy);
	}

	/**
	 * Simple object to hold the response
	 */
	class Response {
		public Response(Date start, Date end, int count) {
			super();
			this.start = start;
			this.end = end;
			this.count = count;
		}
		Date start;
		Date end;
		int count = 0;
		public Date getStart() { return start;}
		public Date getEnd() { return end; }
		public int getCount() { return count; }
	}
	
	/**
	 * POJO for an entry event.
	 */
	class Entry {
		Date entryTime;
		int count;
		EntryType type;
		
		public Entry(Date entryTime, int count, EntryType type) {
			super();
			this.entryTime = entryTime;
			this.count = count;
			this.type = type;
		}

		public Date getEntryTime() {
			return entryTime;
		}

		public int getCount() {
			return count;
		}

		public EntryType getType() {
			return type;
		}
	}
}
