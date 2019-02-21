package org.cdl.demo.core.service.content;

import org.cdl.demo.core.entity.content.Content;
import org.cdl.demo.core.entity.model.field.Field;
import org.cdl.demo.core.entity.model.field.FieldValue;
import org.cdl.demo.core.repository.content.ContentDao;
import org.cdl.demo.core.service.BaseService;

public interface ContentService extends BaseService<Content, ContentDao> {

	FieldValue<?> createFieldValue(Content content, Field field);

}
