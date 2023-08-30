package com.cooksys.twitter_api.services;

import com.cooksys.twitter_api.dtos.TweetResponseDto;
import com.cooksys.twitter_api.entities.Tweet;

import java.util.List;

public interface TweetService {

    List<TweetResponseDto> getAllActiveTweets();

    Tweet getTweet(Long id);

    TweetResponseDto getTweetById(Long id);
}
