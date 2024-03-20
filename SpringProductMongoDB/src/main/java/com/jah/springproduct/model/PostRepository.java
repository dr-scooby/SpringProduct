/**
 * 
 */
package com.jah.springproduct.model;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoRepository is the Spring mapping to the MongoDB. It will take care of the CRUD.
 * it takes the POJO and primary key, in this case use String
 */
public interface PostRepository extends MongoRepository<Post, String>{

}
