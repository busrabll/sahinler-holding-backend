package sahinler.holding.socialMediaApp.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sahinler.holding.socialMediaApp.business.abstracts.PostService;
import sahinler.holding.socialMediaApp.business.requests.CreatePostRequest;
import sahinler.holding.socialMediaApp.business.requests.UpdatePostRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllPostsResponse;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostsController {
	
	private PostService postService;
	
	@GetMapping
	public List<GetAllPostsResponse> getAll(){
		return postService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreatePostRequest createPostRequest) {
		this.postService.add(createPostRequest);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody UpdatePostRequest updatePostRequest) {
		this.postService.update(id, updatePostRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.postService.delete(id);
	}
	
}
