package ua.nure.osmachko.summarytask4.locale.i18n;

public enum LocaleType {

	EN("en"),RU("ru");
	
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private LocaleType(String value) {
		this.setValue(value);
	}
	
	
	public static LocaleType fromString(String str) {
		for(LocaleType item : LocaleType.values()) {
			if(item.getValue().equalsIgnoreCase(str)){
				return item;
			}
		}
		return LocaleType.EN;
	}
	
}
