package sahinler.holding.socialMediaApp.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sahinler.holding.socialMediaApp.business.abstracts.PostService;
import sahinler.holding.socialMediaApp.business.requests.CreatePostRequest;
import sahinler.holding.socialMediaApp.business.requests.UpdatePostRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllPostsResponse;
import sahinler.holding.socialMediaApp.model.Post;

@CrossOrigin(origins="http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/api/posts")
public class PostsController {

	@Autowired
	private PostService postService;

	@GetMapping
	private List<GetAllPostsResponse> getAll() {
		return postService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<GetAllPostsResponse> getPostDetails(@PathVariable("id") int id) {
		GetAllPostsResponse post = postService.getPostById(id);
		return ResponseEntity.status(HttpStatus.OK).body(post);
	}

	/*@PostMapping*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Post> add(@RequestBody @Valid CreatePostRequest createPostRequest) {
		Post post = this.postService.add(createPostRequest);
		return ResponseEntity.status(HttpStatus.OK).body(post);
	}
	
	@PutMapping("/{id}")
	public Post update(@RequestBody UpdatePostRequest updatePostRequest, @PathVariable int id) {
		return this.postService.update(updatePostRequest, id);		
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		this.postService.delete(id);
		return "Deleted Successfully";
	}

}
