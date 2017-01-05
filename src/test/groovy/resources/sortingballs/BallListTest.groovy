package resources.sortingballs

import spock.lang.Specification

public class BallListTest extends Specification {
		
	def BallList testObj;
		
	def setup(){
		testObj = new BallList()
	}
	
	def "containsBall returns true, when two balls are added"(){
		boolean result
		
		given:
		def ball1 = new Ball(23)
		def ball2 = new Ball(12)

		when:
		testObj.addBall(ball1)
		testObj.addBall(ball2)
		result = testObj.containsBall(ball2)
		
		then: "returns true"
		result
	}
	
	def "containsBall returns false, when one balls is added"(){
		boolean result
		
		given:
		def ball1 = new Ball(23)
		def ball2 = new Ball(12)
		
		when:
		testObj.addBall(ball1)
		testObj.containsBall(ball2)
		
		then: "returns false"
		!result
	}
	
	def "Add one element to array and verify array"(){
		
		given:
		def ball1 = new Ball(43)
		
		when:
		testObj.addBall(ball1)
		
		then: "returns sorted array"
		testObj.getBalls() == [ball1]
	}
	
	def "prove the quicksort, adding several elements to array"(){
		
		given:
		def ball1 = new Ball(43)
		def ball2 = new Ball(25)
		def ball3 = new Ball(32)
		def ball4 = new Ball(2)
		
		when:
		testObj.addBall(ball1)
		testObj.addBall(ball2)
		testObj.addBall(ball3)
		testObj.addBall(ball4)
		
		then: "returns sorted array"
		testObj.getBalls() == [ball4,ball2,ball3,ball1]
	}
	
}
