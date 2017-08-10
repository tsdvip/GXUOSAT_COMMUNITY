/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2017年4月23日
 *
 * GXUOSAT_COMMUNITY Maven Webapp
 * com.tsdvip.service
 * AdminServiceImp.java
 */
package com.tsdvip.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsdvip.dao.AnswerDao;
import com.tsdvip.dao.BoardDao;
import com.tsdvip.dao.NoticeDao;
import com.tsdvip.dao.PostDao;
import com.tsdvip.dao.UserDao;
import com.tsdvip.entity.Board;
import com.tsdvip.entity.Notice;
import com.tsdvip.entity.Post;
import com.tsdvip.entity.User;
import com.tsdvip.util.DateUtil;


/**
 * 
 * @author tanshangodng
 * @since 2017年4月23日 下午6:57:33
 * @version   
 */
@Service
public class AdminServiceImp implements AdminService{
	
	@Resource
	private UserDao userDao;
	@Resource
	private BoardDao boardDao;
	@Resource
	private PostDao postDao;
	@Resource
	private AnswerDao answerDao;
	@Resource
	private NoticeDao noticeDao;
	

	public List<Map<String, Object>> getAllUser() {
		List<User> users = userDao.findAll();
		List<Map<String,Object>> userList = new ArrayList<Map<String,Object>>();
		for(User user : users){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", user.getUserId());
			map.put("userName", user.getUserName());
			map.put("roleName", userDao.findUserRoleName(user.getRoleId()));
			map.put("phone", user.getPhone());
			map.put("email", user.getEmail());
			userList.add(map);
		}
		
	    return userList;
    }

	public List<Map<String, Object>> getAllBoards() {
	    List<Board> boards = boardDao.findAll();
	    List<Map<String,Object>> boardList = new ArrayList<Map<String,Object>>();
	    
	    for(Board board : boards){
	    	Map<String,Object> map = new HashMap<String,Object>();
	    	map.put("boardId", board.getBoardId());
	    	map.put("boardName", board.getBoardName());
	    	map.put("description", board.getDescription());
	    	map.put("masterName", userDao.findUserById(board.getMasterId()).getUserName());
	    	boardList.add(map);
	    }
	    return boardList;
    }

	public void deleteBoardByBoardId(Integer boardId) {
		List<Post> posts = postDao.findAllByBoardId(boardId);
		for(Post post : posts){
			answerDao.deleteAnswerByPostId(post.getPostId());
		}
		
		postDao.deletePostByBoardId(boardId);
		boardDao.deleteBoardByBoarId(boardId);
    }

	public List<Map<String, Object>> getAllPosts() {
		
		List<Post> posts = postDao.findAll();
		List<Map<String,Object>> postList = new ArrayList<Map<String,Object>>();
		for(Post post : posts){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("postId", post.getPostId());
			Board board = boardDao.findBoardByBoardId(post.getBoardId());
			map.put("boardName", board.getBoardName());
			map.put("title", post.getTitle());
			User user = userDao.findUserById(post.getUserId());
			map.put("userName", user.getUserName());
			map.put("postTime", post.getPostTime());
			postList.add(map);
		}
	    return postList;
    }

	public void boardManager(Integer boardId,Integer userId, String boardName,
            String description, String masterName) {
		Board board = new Board();
		board.setBoardName(boardName);
		board.setDescription(description);
		board.setMasterId(userId);
		if(boardId == null){
			board.setBoardId(boardDao.getMaxBoardId()+1);
			boardDao.insertBoard(board);
		}else{
			board.setBoardId(boardId);
			boardDao.updateBoard(board);
		}
    }

	public void noticeManager(Integer noticeId, String content, String ymd) {
		Notice notice = new Notice();
		notice.setContent(content);
		notice.setYmd(ymd);
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		notice.setPostTime(time);
		if(noticeId==null){
			Integer maxNoticeId = noticeDao.getMaxNoticeId();
			if(maxNoticeId != null){
				notice.setNoticeId(maxNoticeId + 1);
			}else{
				notice.setNoticeId(1);
			}
			noticeDao.insertNotice(notice);
		}else{
			notice.setNoticeId(noticeId);
			noticeDao.updateNotice(notice);
		}
		
    }

	public List<Integer> getPostNum(List<String> dates) {
		List<Integer> postNum = new ArrayList<Integer>();
		for(String date : dates){
			date = DateUtil.getStrDate(DateUtil.getDate(date, "yyyyMMdd"), "yyyy-MM-dd");
			postNum.add(postDao.countAllByDate("%"+date+"%")==null ? 0 : postDao.countAllByDate("%"+date+"%"));
		}
	    return postNum;
    }

}
