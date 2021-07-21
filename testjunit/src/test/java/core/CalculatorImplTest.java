package core;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorImplTest {
	
	private CalculatorImpl object;
	
	@BeforeEach
	public void setUp() {
		object = new CalculatorImpl();
	}

	@Test
	@Disabled
	@DisplayName("Test is successful on passing even value")
	void testEvenNumbers() {
		//setup
		
		
		//verify
		assertTrue(object.evenNumbers(2));
		
		
	}
	
	@Test
	@Disabled
	@DisplayName("Test is faliure on passing even value")
	void testEvenNumberswithOddValue() {

		//verify
		assertTrue(object.evenNumbers(7));
	}

    @ParameterizedTest
    @Disabled
    @ValueSource(ints = {0,2,4,6,10,210,897})
	public void testEvenNumberWithMultipleValues(int number) {
		assertTrue(object.evenNumbers(number));
	}
    
    
    @ParameterizedTest
    @MethodSource("generateValues")
	public void testEvenNumberWithMultipleValuesMethodSource(int number) {
		assertTrue(object.evenNumbers(number));
	}
    
    public static IntStream generateValues(){
    	return	IntStream.range(3, 10)
		;
    	
    }
    
    
    @ParameterizedTest
    @CsvSource({"1,1,2", "3,2,5", "-1,2,3"})
    public void testSumofNumbers(int num1 ,int num2,int sum) {
 assertEquals(sum , object.add(num1,num2));
    }

	
}
