package org.cdl.demo.core.service.content;

import java.util.List;

import org.cdl.demo.core.entity.content.Content;
import org.cdl.demo.core.repository.content.ContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

	@Autowired
	private ContentDao contentDao;

	public List<Content> findAll() {
		return contentDao.findAll();
	}

	public Content findById(Long id) {
		return contentDao.findById(id).get();
	}

	public Content save(Content content) {
		return contentDao.save(content);
	}

	public void delete(Long id) {
		contentDao.deleteById(id);
	}

}
