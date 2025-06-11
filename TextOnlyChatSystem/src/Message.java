import java.io.Serializable;
import java.util.List;

public class Message implements Serializable{
	private User sender = null;
	private List<User> receivers = null;
	private MessageType messageType = null;
	private String content = null;
	
	public Message(String content) {
		this.content = content;
	}
	//contructor to send text messages
	public Message(User sender, List<User> receivers, MessageType messageType, String Content) {
		this.sender = sender;
		this.receivers = receivers;
		this.messageType = messageType;
		this.content = content;
		
	}
	
	//Constructor for server to send back messages 
	public Message(MessageType messageType) {
		
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public List<User> getReceivers() {
		return receivers;
	}
	public void setReceivers(List<User> receivers) {
		this.receivers = receivers;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
