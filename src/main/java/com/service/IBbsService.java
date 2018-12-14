package com.service;

import com.common.ServerResponse;
import com.pojo.Bbs;

/**
 */
public interface IBbsService {
	ServerResponse addNote(Bbs bbs);

	ServerResponse addReply(Bbs bbs);

	ServerResponse addLike(Bbs bbs);
}
