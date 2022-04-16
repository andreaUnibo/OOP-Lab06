package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }
    
    private static final long AFRICA = 1_110_635_000;
    private static final long AMERICA= 972_005_000;
    private static final long ANTARCTICA= 0;
    private static final long ASIA= 4_298_723_000L;
    private static final long EUROPE= 742_452_000;
    private static final long OCEANIA= 38_304_000;
    
    public static void main(final String... s) {
    	
    	
    	
    	
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	ArrayList<Integer> ar = new ArrayList<Integer>();
    	for(int i = 1000; i < 2000; i++) {
    		ar.add(i);
    	}
    	
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	LinkedList<Integer> ll = new LinkedList<Integer>();
    	ll.addAll(ar);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int var;
    	var = ll.get(0);
    	ll.set(0, ll.get(ll.size()-1));
    	ll.set(ll.size()-1,var);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (Integer integer : ar) {
			System.out.println(integer);
		}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	 long timer = System.nanoTime();
    	 for(int i = 0;i < 100000; i++) {
    		 ar.add(0,i);
    	 }
    	 timer = System.nanoTime() - timer;
    	
    	 long timell = System.nanoTime();
    	 for(int i = 0;i < 100000; i++) {
    		 ll.add(0,i);
    	 }
    	 timell = System.nanoTime() - timell;
    	 
    	 System.out.println("time ar: "+timer+" Time ll: "+timell);
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	timer = System.nanoTime();
    	 for(int i = 0;i < 1000; i++) {
    		 ar.get(ar.size()/2);
    	 }
    	 timer = System.nanoTime() - timer;
    	
    	 timell = System.nanoTime();
    	 for(int i = 0;i < 1000; i++) {
    		 ll.get(ll.size()/2);
    	 }
    	 timell = System.nanoTime() - timell;
    	 
    	 System.out.println("time ar: "+timer+" Time ll: "+timell);
    	 
    	 
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	 HashMap<String,Long> hm = new HashMap<String,Long>(); 
    	 hm.put("Americas", AMERICA);
    	 hm.put("Africa", AFRICA);        
         hm.put("Antarctica", ANTARCTICA);
         hm.put("Asia", ASIA);
         hm.put("Europe", EUROPE);
         hm.put("Oceania", OCEANIA);
        /*
         * 8) Compute the population of the world
         */
    	 long  pop = 0;
    	 for (long population : hm.values()) {
             pop += population;
         }
    	 System.out.println("population:"+pop);
    }
}
