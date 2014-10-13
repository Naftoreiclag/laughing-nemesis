package naftoreiclag.laughingnemesis.memory;

public abstract class AMemory
{
	// With this key present, the memory can be read instantly
	protected int secretAccessKey;
	
	protected float decayRate;
	protected float recallRate;
	
	public abstract boolean sameType(AMemory other);
}
