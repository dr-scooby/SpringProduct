/**
 * 
 */
package com.jah.springproduct.model;

import java.util.List;

/**
 * Custom search for the MongoDB searching
 */
public interface SearchRepository {
	
	
	List<Post> findByText(String text);

}
