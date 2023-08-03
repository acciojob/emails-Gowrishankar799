package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings
    private int inboxcapacity;

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        calendar=new ArrayList<>();

        calendar = new ArrayList<>();


    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        calendar.sort((a, b) -> a.getEndTime().compareTo(b.getEndTime()));
        int ans=0;
        LocalTime currentTime = LocalTime.of(0, 0); // Start from time 00:00

        for (Meeting meeting : calendar) {
            // If the current meeting's start time is after the current time,
            // it means we can attend it without any conflicts.
            if (meeting.getStartTime().compareTo(currentTime) >= 0) {
                ans++;
                currentTime = meeting.getEndTime();
            }
        }
        return ans;
    }

    }

/*package com.driver;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        calendar=new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        calendar.sort((a, b) -> a.getEndTime().compareTo(b.getEndTime()));
        int ans=0;
        LocalTime currentTime = LocalTime.of(0, 0); // Start from time 00:00

        for (Meeting meeting : calendar) {
            // If the current meeting's start time is after the current time,
            // it means we can attend it without any conflicts.
            if (meeting.getStartTime().compareTo(currentTime) >= 0) {
                ans++;
                currentTime = meeting.getEndTime();
            }
        }
        return ans;
    }
}*/

