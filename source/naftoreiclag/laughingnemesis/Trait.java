package naftoreiclag.laughingnemesis;

public enum Trait
{
	athletic,
	lazy,
	spiritual,
	logical,
	ignorant,
	cognizant,
	deceptive,
	honest,
	manipulative,
	sociopathic,
	societal,
	maverick,
	gluttonous,
	shy;
	
	// Traits which by definition conflict with one another (e.g. rational and irrational)
	Trait[] inherentConflicts;
	
	// Traits which are near-synonyms (e.g. deceptive and manipulative)
	Trait[] trends;
}
