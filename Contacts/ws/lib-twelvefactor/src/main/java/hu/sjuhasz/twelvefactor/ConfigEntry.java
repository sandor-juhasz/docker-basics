package hu.sjuhasz.twelvefactor;

public class ConfigEntry {

	private final String name;
	private final String description;
	
	public ConfigEntry(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	
}
