package test;

import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;


    public Message(byte[] data) {
        this.data = data;
        //Conversion to byte in UTF8 encoding
        this.asText = new String(data,java.nio.charset.StandardCharsets.UTF_8);
        this.asDouble = tryparseFromText(this.asText);
        this.date = new Date();
    }

    public Message(String asText) {
        this(asText.getBytes());
    }

    public Message(double asDouble) {
        this(Double.toString(asDouble));
    }

    private double tryparseFromText(String text)  {
        try {
            return Double.parseDouble(text);
        }
        catch (NumberFormatException nfe)
        {
           return Double.NaN;
        }
    }


}
