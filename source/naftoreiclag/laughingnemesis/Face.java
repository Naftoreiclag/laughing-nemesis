package naftoreiclag.laughingnemesis;

public class Face
{
	public long id;
	
	public Face()
	{
		id = GR.r.nextLong();
	}
	
	public boolean equals(Face face)
	{
		return face.id == id;
	}
}
