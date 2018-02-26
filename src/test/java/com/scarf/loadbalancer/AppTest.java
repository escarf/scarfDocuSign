package com.scarf.loadbalancer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );

    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    
    public void testSingle(){
    	App a = new App();
    	String[] test = new String[1];
    	test[0] = "X:1";
    	String result = a.doWork(test);
    	assertEquals(result, "X");
    }
    public void testEmpty(){
    	App a = new App();
    	String[] test = new String[0];
    	
    	String result = a.doWork(test);
    	assertEquals(result, "X");
    }
    public void testZero(){
    	App a = new App();
    	String[] test = new String[0];
    	
    	String result = a.doWork(test);
    	assertEquals(result, "X");
    }
    public void testSizeZero(){
    	App a = new App();
    	String[] test = new String[1];
    	test[0] = "X:0";
    	
    	String result = a.doWork(test);
    	assertEquals(result, "X");
    }
    public void IncludesZero(){
    	App a = new App();
    	String[] test = new String[2];
    	test[0] = "X:1";
    	test[1] = "Y:0";
    	
    	String result = a.doWork(test);
    	assertEquals(result, "X");
    }
    
}
