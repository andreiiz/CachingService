package it.unibo.chachingservice.entity;

import org.bson.types.ObjectId;

@org.springframework.data.mongodb.core.mapping.Document(collection = "agent")
public class Agent {

	private ObjectId _id;
	private String name;
	private String url;
	
	public Agent() {
		super();
	}

	public Agent(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
