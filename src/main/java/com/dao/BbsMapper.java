package com.dao;

import com.pojo.Bbs;
import com.pojo.Content;

/**
 * <p>Description: </p>
 *
 * @author:boboan
 * @version:1.0
 */
public interface BbsMapper {


	int addNote(Bbs bbs);

	int addReply(Bbs bbs);

	int addLike(Bbs bbs);

	int updateLike(Bbs bbs);

	Bbs select(Integer id);
}
