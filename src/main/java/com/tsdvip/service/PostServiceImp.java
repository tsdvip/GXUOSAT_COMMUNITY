/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月12日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.service
 * PostServiceImp.java
 */
package com.tsdvip.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsdvip.dao.AnswerDao;
import com.tsdvip.dao.PostDao;
import com.tsdvip.dao.UserDao;
import com.tsdvip.entity.Answer;
import com.tsdvip.entity.Page;
import com.tsdvip.entity.Post;
import com.tsdvip.entity.User;


/**
 * 
 * @author 
 * @since 2017年4月12日 下午8:44:14
 * @version   
 */
@Service("postService")
public class PostServiceImp implements PostService{

	@Resource 
	PostDao postDao;
	@Resource 
	AnswerDao answerDao;
	@Resource 
	UserDao userDao;
	
	public Integer countGood(Integer boardId) {
	    return postDao.countGood(boardId);
    }

	public Integer countAllPost(Integer boardId) {
	    return postDao.countAllPost(boardId);
    }

	public Integer countTodayPost(String date, Integer boardId){
		return postDao.countTodayPost("%"+date+"%", boardId);
	}

	public List<Map<String, Object>> getPostByPage(Page page) {
		List<Post> postList = postDao.findPostByPage(page);
		
		List<Map<String, Object>> objList = new ArrayList<Map<String, Object>>();
		for(Post post : postList){
			Map<String,Object> objMap = new HashMap<String,Object>();
			objMap.put("boardId", post.getBoardId());
			objMap.put("postId", post.getPostId());
			if(post.getIs_good() != null && post.getIs_good().equalsIgnoreCase("Y")){
		    	String title = post.getTitle();
		    	post.setTitle("【精华帖】   "+title);
		    }
			objMap.put("title", post.getTitle());
			User user = userDao.findUserById(post.getUserId());
			objMap.put("userName", user.getNickname());
			objMap.put("face", user.getFace());
			String content = post.getContent();
			if(content != null){
				if(content.length()>100){
					content = content.substring(0, 100);
				}
			}
			objMap.put("content", content);
			objMap.put("postTime", post.getPostTime());
			int answerNum = answerDao.countAnswer(post.getPostId());
			objMap.put("answerNum", answerNum);
			objList.add(objMap);
		}
		return objList;
    }

	public Map<String, Object> getPostContent(Integer postId) {
	    Post post = postDao.findPostByPostId(postId);
	    User user = userDao.findUserById(post.getUserId());
	    Map<String,Object> map = new HashMap<String,Object>();
	    if(post.getIs_good() != null && post.getIs_good().equalsIgnoreCase("Y")){
	    	String title = post.getTitle();
	    	post.setTitle("【精华帖】  "+title);
	    }
	    map.put("post", post);
	    map.put("user", user);
	    return map;
    }

	public List<Map<String, Object>> getPostAnswers(Integer postId) {
		List<Map<String, Object>> allAnswers = new ArrayList<Map<String, Object>>();
		List<Answer> answers = answerDao.findAnswerByPostId(postId);
		for(Answer answer : answers){
			Map<String,Object> map = new HashMap<String,Object>();
			User user = userDao.findUserById(answer.getUserId());
			map.put("answerId", answer.getAnswerId());
			map.put("answer", answer);
			map.put("user", user);
			allAnswers.add(map);
		}
	    return allAnswers;
    }

	public void savePost(Post post) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		post.setPostTime(sdf.format(date));
		post.setPostId(postDao.getMaxPostId()+1);
	    postDao.insertPost(post);
    }

	public void saveAnswer(Answer answer) {
		Date date = new Date(System.currentTimeMillis());
		if(answerDao.getMaxAnswerId()==null){
			answer.setAnswerId(1);
		}else{
			answer.setAnswerId(answerDao.getMaxAnswerId()+1);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    answer.setAnswerTime(sdf.format(date));
	    answerDao.insertAnswer(answer);
    }

	public void deletePostById(Integer postId) {
	    answerDao.deleteAnswerByPostId(postId);
	    postDao.deletePostById(postId);
    }

	public void deletePostAnswer(Integer answerId) {
	    answerDao.deleteAnswerByAnswerId(answerId);
	    
    }

}
