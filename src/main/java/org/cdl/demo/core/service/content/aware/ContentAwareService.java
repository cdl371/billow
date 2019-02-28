package org.cdl.demo.core.service.content.aware;

import java.util.List;
import java.util.Map;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.Content;
import org.cdl.demo.core.entity.content.aware.ContentAware;
import org.cdl.demo.core.entity.model.FieldGroup;
import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.entity.model.field.Field;
import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.entity.model.field.FieldValue;
import org.cdl.demo.core.repository.BaseDao;
import org.cdl.demo.core.repository.content.aware.ContentAwareDao;
import org.cdl.demo.core.service.BaseService;
import org.cdl.demo.core.service.content.ContentService;

public interface ContentAwareService<T extends Base & ContentAware, DAO extends BaseDao<T>>
		extends BaseService<T, DAO> {

	static final String FIELD_PREFIX = "field.";

	ContentAwareDao<T> getContentAwareDao();

	ContentService getContentService();

	default void attachContent(T contentAware, Model model, Map<String, String[]> requestParameterMap,
			Map<String, FieldType<?>> fieldTypeMap) {
		Content content;
		if (contentAware.isNew()) {
			content = getContentService().save(new Content(model));
		} else {
			content = findById(contentAware.getId()).getContent();
		}
		List<FieldValue<?>> fieldValues = content.getFieldValues();
		fieldValues.clear();
		for (FieldGroup fieldGroup : content.getModel().getFieldGroups()) {
			for (Field field : fieldGroup.getFields()) {
				String code = field.getCode();
				FieldType<?> fieldType = fieldTypeMap.get(field.getType());
				List<FieldValue<?>> fvs = fieldType.createFieldValues(content, code,
						requestParameterMap.get(FIELD_PREFIX + code));
				fieldValues.addAll(fvs);
			}
		}
		content.setFieldValues(fieldValues);
		contentAware.setContent(content);
	}

}
