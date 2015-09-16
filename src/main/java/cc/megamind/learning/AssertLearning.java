package cc.megamind.learning;

import org.testng.annotations.Test;

public class AssertLearning {

    public  void testSumPositiveNumbersOneAndOne() {
    	System.out.println("1+1 = 2");
    	assert((1+1) == 6);
    }
 
    @Test
    public  void testSumPositiveNumbersOneAndTwo() {
    	System.out.println("1+2 = 3");
        assert((1+2) == 3);
    }
    
//    public static void main(String [] args) {
//    	testSumPositiveNumbersOneAndOne();
//    	testSumPositiveNumbersOneAndTwo();
//    }
}
