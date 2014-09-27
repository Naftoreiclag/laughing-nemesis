package naftoreiclag.laughingnemesis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Gender
{
	// Don't worry. I can add more later.
	
	male,
	female;

	public static Random rand = new Random();
	public static List<Gender> genderList = Collections.unmodifiableList(Arrays.asList(values()));

	public static Gender getRandomGender()
	{
		return genderList.get(rand.nextInt(genderList.size()));
	}
}
