package com.fetch.receipt.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import com.fetch.receipt.beans.Item;

/**
 * 
 * All Common and reusable methods used in applications
 * @author Divya
 *
 */
public class Util {
	
	public static int PURCHASE_TIME_START_HOURS = 14 ;
	public static int PURCHASE_TIME_END_HOURS = 16 ;
	public static int PURCHASE_TIME_MIN = 0 ;
	
	public static int getAlphaNumaricCount(String str) {
		int count=0;
		for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                count++;
            }
        }
		return count ;
		
	}
	public static int isTotalRounded(double total) {
		if(Math.round(total) == total) {
			return 50;
		} else {
			return 0;
		}
	}
	
    public static int isTotalMultipleOfQuarter(double total) {
	    if(total % 0.25 == 0) {
	    	return 25 ;
	    } else {
	    	return 0;
	    }
	}
    
    public static int getNumberOfItemPairs(double total) {
	    if(total % 2 == 0) {
	    	return 25 ;
	    } else {
	    	return 0;
	    }
	}
    
    public static int isPurchaseDateIdOdd(String purchaseDate) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(sdf.parse(purchaseDate));
	    if (cal.get(Calendar.DAY_OF_MONTH) % 2 == 0) {
	    	 return  0 ;
	    } else {
	    	 return  6;
	    }
	}
    
    public static int isPurchaseTimeBtw(String purchaseTime)   {
    	 LocalTime startTime = LocalTime.of(PURCHASE_TIME_START_HOURS,PURCHASE_TIME_MIN );  
         LocalTime endTime = LocalTime.of(PURCHASE_TIME_END_HOURS, PURCHASE_TIME_MIN);  
         LocalTime pTime = LocalTime.of(Integer.parseInt(purchaseTime.split(":")[0]),
        		 Integer.parseInt(purchaseTime.split(":")[1]));
         if (pTime.isAfter(startTime) && pTime.isBefore(endTime)) {
        	 return 10;
         } else {
        	 return 0;
         }
	}
    
    public static long getItemsDescPoints(ArrayList<Item> items) {
     long points = 0 ;
   	 for(Item item : items) {
   		 if(item.getShortDescription() != null && item.getShortDescription().trim().length() % 3 == 0) {
   			points = points + Double.valueOf(Math.ceil(Double.parseDouble(item.getPrice()) * 0.2 )).longValue();
   		 }
   	 }
   	 return points;
	}
    
    
    
	
}
