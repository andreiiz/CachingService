package it.unibo.chachingservice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import it.unibo.chachingservice.entity.FsFiles;

public interface FsFilesRepository extends MongoRepository<FsFiles, ObjectId> {

}
