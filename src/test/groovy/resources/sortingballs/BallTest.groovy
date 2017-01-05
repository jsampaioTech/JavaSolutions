package resources.sortingballs

import resources.sortingballs.Ball
import spock.lang.Specification;

public class BallTest extends Specification {

	def Ball testObj;

	def setup(){
		testObj = new Ball(5)
	}

	def "get ball number"(){

		when: "Create ball"
		testObj.getNumber()

		then: "get number should be 5"
		testObj.getNumber() == 5
	}

	def "Is valid number, returns false"(){
		boolean result

		given:
		def number = 63

		when:
		result = testObj.isValidNumber(number)

		then: "returns false"
		!result
	}
	
	def "Is valid number, returns true"(){
		boolean result

		given:
		def number = 58

		when:
		result = testObj.isValidNumber(number)

		then: "returns true"
		result
	}
}
