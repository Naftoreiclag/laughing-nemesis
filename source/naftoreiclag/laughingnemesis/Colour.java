package naftoreiclag.laughingnemesis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// I see u
public enum Colour
{
	red,
	orange,
	yellow,
	green,
	blue,
	purple,
	black,
	white,
	brown;
	
	public static List<Colour> colorList = Collections.unmodifiableList(Arrays.asList(values()));

	public static Colour getRandomColor()
	{
		return colorList.get(GR.r.nextInt(colorList.size()));
	}
}
