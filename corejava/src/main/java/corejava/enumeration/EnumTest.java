package corejava.enumeration;

import corejava.enumeration.EnumDeclaration.Direction;

public class EnumTest {

	public static void main(String[] args) {
		Direction day = Direction.EAST;
		System.out.println(day);
		
		for (Direction tempDay : Direction.values()) {
			System.out.println(tempDay);
		}
		
	}
}
