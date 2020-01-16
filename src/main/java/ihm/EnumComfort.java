package ihm;

public enum EnumComfort {
    A("Relaxing"),
    B("Sportive"),
    C("Historic"),
    D("Intense"); 
    
    
    private String text;

	EnumComfort(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static EnumComfort fromString(String text) {
        for (EnumComfort b : EnumComfort.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}