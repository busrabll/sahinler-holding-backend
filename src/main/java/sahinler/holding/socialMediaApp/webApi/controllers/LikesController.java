package sahinler.holding.socialMediaApp.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sahinler.holding.socialMediaApp.business.abstracts.LikeService;
import sahinler.holding.socialMediaApp.business.requests.CreateLikeRequest;
import sahinler.holding.socialMediaApp.business.responses.GetAllLikesResponse;
import sahinler.holding.socialMediaApp.model.Like;

/*@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)*/
@RestController
@RequestMapping("/api/likes")
public class LikesController {

	@Autowired
	private LikeService likeService;

	@GetMapping
	private List<GetAllLikesResponse> getAll(@PathVariable("userId") Optional<Integer> userId,
			@PathVariable("postId") Optional<Integer> postId) {
		return likeService.getAll(userId, postId);
	}

	/*
	 * @PostMapping()
	 * 
	 * @ResponseStatus(code = HttpStatus.CREATED) public void add(@RequestBody()
	 * CreateLikeRequest createLikeRequest) {
	 * this.likeService.add(createLikeRequest); }
	 */

	/*@PostMapping*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Like> add(@RequestBody CreateLikeRequest createLikeRequest) {
		Like like = this.likeService.add(createLikeRequest);
		return ResponseEntity.status(HttpStatus.OK).body(like);
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST) public void add(@RequestBody
	 * CreateLikeRequest createLikeRequest) {
	 * this.likeService.add(createLikeRequest); }
	 */

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.likeService.delete(id);
	}

}
