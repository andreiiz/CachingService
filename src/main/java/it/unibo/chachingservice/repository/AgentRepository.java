package it.unibo.chachingservice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import it.unibo.chachingservice.entity.Agent;

public interface AgentRepository  extends MongoRepository<Agent, ObjectId>{

	public Agent findByName(String name);
}
