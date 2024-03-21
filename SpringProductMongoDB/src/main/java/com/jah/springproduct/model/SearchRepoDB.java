/**
 * 
 */
package com.jah.springproduct.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
//import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;


/**
 * Tells Spring to read this class
 */
@Component
public class SearchRepoDB implements SearchRepository{

	@Autowired
	MongoClient client;
	
	@Autowired
	MongoConverter converter;
	
	
	@Override
	public List<Post> findByText(String text) {
		// Create new List of Posts
		
		List<Post> posts = new ArrayList<>();
		
		MongoDatabase database = client.getDatabase("Redhawk1");
		MongoCollection<Document> collection = database.getCollection("JobPost");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("text", 
		    new Document("query", text)
		                .append("path", Arrays.asList("techs", "desc", "profile")))), 
		    new Document("$sort", 
		    new Document("exp", 1L)), 
		    new Document("$limit", 5L)));
		
		// need to convert the result to a Post object and iterate and add it to the posts Array
		result.forEach(doc -> posts.add(converter.read(Post.class, doc)));
		
		return posts;
	}

}
