package naftoreiclag.laughingnemesis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Gender
{
	// Don't worry. I can add more later.
	
	male,
	female;

	public static List<Gender> genderList = Collections.unmodifiableList(Arrays.asList(values()));

	public static Gender getRandomGender()
	{
		return genderList.get(GR.r.nextInt(genderList.size()));
	}
}
