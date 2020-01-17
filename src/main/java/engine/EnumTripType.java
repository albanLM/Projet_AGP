package engine;

public enum EnumTripType {
    A("Lazy"),
    B("Dynamic"); 
    
    
    private String text;

    EnumTripType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static EnumTripType fromString(String text) {
        for (EnumTripType b : EnumTripType.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}