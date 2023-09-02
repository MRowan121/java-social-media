package com.cooksys.twitter_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.twitter_api.dtos.HashtagDto;
import com.cooksys.twitter_api.dtos.TweetResponseDto;
import com.cooksys.twitter_api.entities.embeddable.Credentials;
import com.cooksys.twitter_api.services.TweetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class TweetController {

	private final TweetService tweetService;

	@GetMapping
	public List<TweetResponseDto> getAllActiveTweets() {
		return tweetService.getAllActiveTweets();
	}

	@GetMapping("/{id}")
	public TweetResponseDto getTweetById(@PathVariable Long id) {
		return tweetService.getTweetById(id);
	}

    @DeleteMapping("/{id}")
    public TweetResponseDto deleteTweetById(@PathVariable Long id, @RequestBody Credentials credentials) {
        return tweetService.deleteTweetById(id, credentials);
    }

    @PostMapping("/{id}/like")
    public void addLikeToTweet(@PathVariable Long id, @RequestBody Credentials credentials) {
        tweetService.addLikeToTweet(id, credentials);
    }

    @GetMapping("/{id}/tags")
    public List<HashtagDto> getTweetByTags(@PathVariable Long id) {
    	return tweetService.getTweetByTags(id);
    }
    
    
}