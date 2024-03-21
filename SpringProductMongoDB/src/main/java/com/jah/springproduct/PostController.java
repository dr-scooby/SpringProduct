/**
 * from YouTube: https://www.youtube.com/watch?v=Jl9OKQ92SJU
 */

package com.jah.springproduct;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

import com.jah.springproduct.model.Post;
import com.jah.springproduct.model.PostRepository;
import com.jah.springproduct.model.SearchRepository;

@RestController
public class PostController {
	
	@Autowired
	PostRepository repo; // Spring will create the class of the PostRepository
	
	@Autowired
	SearchRepository srepo; // our own custom search
	
	
	
	// ApiIgnore will remove swagger operations, we can build our own
	// remove ApiIgnore to see swagger operations
    @ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		// send to swagger, used for testing 
		response.sendRedirect("/swagger-ui.html");
		
	}
	
    @GetMapping("/allPosts")
    public List<Post> getAllPosts(){
    	return repo.findAll();
    }
    
    // add a Post
    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post) {
    	return repo.save(post);
    }
    
    
    // search, get client data to search using {text}
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
    	
    	return srepo.findByText(text);
    }
}
