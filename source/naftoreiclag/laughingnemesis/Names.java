package naftoreiclag.laughingnemesis;

public class Names
{
	public static String getRandomName(Gender gender)
	{
		switch(gender)
		{
			case male: return maleNames[GR.r.nextInt(maleNames.length)];
			case female: return femaleNames[GR.r.nextInt(femaleNames.length)];
		}
		
		return "Nullson";
	}
	
	public static String[] maleNames = new String[]
	{
		"Hosea",
		"Sanford",
		"Marshall",
		"Antione",
		"Marvin",
		"Eli",
		"Jesse",
		"Gino",
		"Russell",
		"Rudolf",
		"Nolan",
		"Lupe",
		"Zachary",
		"Valentine",
		"August",
		"Mel",
		"Nicky",
		"Humberto",
		"Damion",
		"Randy",
		"Billie",
		"Andres",
		"Luke",
		"Ross",
		"Trevor",
		"Nick",
		"Hank",
		"Richie",
		"Cristopher",
		"Leandro",
		"Reuben",
		"Lino",
		"Fermin",
		"Ismael",
		"Archie",
		"Dewitt",
		"Theo",
		"Jonathon",
		"Myles",
		"Berry",
		"Art",
		"Vern",
		"Merrill",
		"Gil",
		"Lou",
		"Sammy",
		"Alden",
		"Mac",
		"Leonel",
		"Arlie"
	};
	
	public static String[] femaleNames = new String[]
	{
		"Sherilyn",
		"Shasta",
		"Earleen",
		"Wendi",
		"Calista",
		"Selina",
		"Meda",
		"Mattie",
		"Kimberly",
		"Kathie",
		"Desirae",
		"Georgiana",
		"Latrice",
		"Sherryl",
		"Minnie",
		"Deidre",
		"Julianne",
		"Alina",
		"Laveta",
		"Huong",
		"Irmgard",
		"Leonila",
		"Johnette",
		"Lura",
		"Susann",
		"Alanna",
		"Su",
		"Tangela",
		"Deedee",
		"Carmelia",
		"Joelle",
		"Filomena",
		"Chasidy",
		"Collette",
		"Ona",
		"Juanita",
		"Myong",
		"April",
		"Fernande",
		"Shawna",
		"Roselle",
		"Queen",
		"Claire",
		"Madeline",
		"Pei",
		"Halley",
		"Hilary",
		"Tiffany",
		"Tess",
		"Liberty"
	};
	
}
