package naftoreiclag.laughingnemesis;

public abstract class Memory
{
	// With this key present, the memory can be read instantly
	protected int secretAccessKey;
	
	protected float decayRate;
	protected float recallRate;
	
	public abstract boolean sameType(Memory other);
}
