package com.fullStackApp.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FullStackAppApplicationTests {

	private Calculator calculator =new Calculator(); 
	@Test
	void contextLoads() {
	}
	
	@Test
	void testDoSum() {
		int expectedResult=20;
		
		int actualResult= calculator.doSum(12, 5, 3);
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	@Test
	public void testProduct()
	{
		//expected result
		int expectedResult=6;
		//actual result
		int actualResult = calculator.product(2, 3);
		
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	
	@Test
	@Disabled
	public void testCompareNum()
	{
		//actual Result
		Boolean actualResult=calculator.compareTwoNumbers(2, 2);
		
		assertThat(actualResult).isTrue();
		
	}

}
