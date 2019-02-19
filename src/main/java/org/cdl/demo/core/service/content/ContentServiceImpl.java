package org.cdl.demo.core.service.content;

import org.cdl.demo.core.repository.content.ContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("contentService")
public class ContentServiceImpl implements ContentService {

	@Autowired
	@Getter
	private ContentDao dao;

}
