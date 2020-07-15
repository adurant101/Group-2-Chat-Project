package chat1;
import java.io.Serializable;

// must implement Serializable in order to be sent
public class Message implements Serializable{
    private static int count = 0;
    private int id;
    private String text;
    private String type;
    
    public Message()
    {
    	text = type = null;
    	id = 0;
    }
    
    public Message(String text) {
        this.text = text;
        this.type = "default";
        this.id = ++count;
    }
    
    public void setText(String t)
    {
    	this.text = t;
    }
    
    public void setId(int i)
    {
    	this.id = i;
    }
    
    public void setType(String t)
    {
    	this.type = t;
    }
    
    public String getText() {
        return text;
    }

    public int getID(){
        return id;
    }

    public String getType(){
        return type;
    }
}

