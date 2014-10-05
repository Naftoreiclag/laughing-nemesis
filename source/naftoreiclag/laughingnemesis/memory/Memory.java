package naftoreiclag.laughingnemesis.memory;

// Brainstamina can be spent to try recover a lost memory
// When trying to remember it, the decaybuffer goes up linearly, 
// and the freshness increases to approach 1 at a rate deterimed by inverse decayRate.
// Decaybuffer will be drained by decayRate
// Whatever, implement forgetting later
public class Memory
{
	protected float freshness;
	protected float decayBuffer;
	protected float decayRate;
}
