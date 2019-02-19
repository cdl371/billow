package org.cdl.demo.core.service.content.aware;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.Content;
import org.cdl.demo.core.entity.content.aware.ContentAware;
import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.repository.BaseDao;
import org.cdl.demo.core.repository.content.aware.ContentAwareDao;
import org.cdl.demo.core.service.BaseService;
import org.cdl.demo.core.service.content.ContentService;

public interface ContentAwareService<T extends Base & ContentAware, DAO extends BaseDao<T>>
		extends BaseService<T, DAO> {

	ContentAwareDao<T> getContentAwareDao();

	ContentService getContentService();

	default void attachContent(T contentAware, Model model) {
		if (contentAware.isNew()) {
			contentAware.setContent(getContentService().save(new Content(model)));
		} else {
			contentAware.setContent(findById(contentAware.getId()).getContent());
		}
	}

}
