package resources.spellsitout

import spock.lang.Specification

public class NumberWordTest extends Specification {
	
	def "check isValidNumber"(){
		boolean result
		
		given: "Number higher than max limit"
		NumberWord testObj = new NumberWord(1233555444)
		
		when:
		result = testObj.isValidNumber()
		
		then: "returns false"
		!result
	}
	
	def "check isValidNumber with a valid number"(){
		boolean result
		
		given:
		NumberWord testObj = new NumberWord(3555444)
		
		when:
		result = testObj.isValidNumber()
		
		then: "returns true"
		result
	}
	
	def "translate invalid number"(){
		String result
				
		given:
		NumberWord testObj = new NumberWord(1000000001)
		
		when:
		result = testObj.getTranslation()
		
		then: "returns null"
		result == null
	}
	
	def "translate valid number"(){
		String result1
		String result2
		String result3
		String result4
		String result5
		String result6
				
		given:
		NumberWord testObj1 = new NumberWord(12000)
		NumberWord testObj2 = new NumberWord(124)
		NumberWord testObj3 = new NumberWord(240004075)
		NumberWord testObj4 = new NumberWord(0)
		NumberWord testObj5 = new NumberWord(14)
		NumberWord testObj6 = new NumberWord(1000000000)
		
		when:
		result1 = testObj1.getTranslation()
		result2 = testObj2.getTranslation()
		result3 = testObj3.getTranslation()
		result4 = testObj4.getTranslation()
		result5 = testObj5.getTranslation()
		result6 = testObj6.getTranslation()
		
		then: "returns the outputs"
		result1 == "twelve thousand"
		result2 == "one hundred twenty-four"
		result3 == "two hundred fourty million four thousand seventy-five"
		result4 == "zero"
		result5 == "fourteen"
		result6 == "one billion"
	}
	
}