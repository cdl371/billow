package org.cdl.demo;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cdl.demo.core.entity.content.Content;
import org.cdl.demo.core.entity.model.field.Field;
import org.cdl.demo.core.entity.model.field.FieldValue;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringBootJpaDemoApplicationTests {
	@PersistenceContext
	private EntityManager em;

	@Test
	@Ignore
	public void contextLoads() {
	}

	@Test
	public void Test1_createFieldType() {
//		StringFieldType stringFieldType = new StringFieldType();
//		stringFieldType.setCode("string");
//		stringFieldType.setName("字符串");
//		em.persist(stringFieldType);
//		IntegerFieldType integerFieldType = new IntegerFieldType();
//		integerFieldType.setCode("integer");
//		integerFieldType.setName("数字");
//		em.persist(integerFieldType);

//		Model model = new Model();
//		model.setName("模型1");
//		em.persist(model);
//		FieldGroup fieldGroup = new FieldGroup();
//		fieldGroup.setName("基本");
//		fieldGroup.setModel(model);
//		em.persist(fieldGroup);
//		Field field1 = new Field();
//		field1.setName("姓名");
//		field1.setFieldGroup(fieldGroup);
//		field1.setFieldType(stringFieldType);
//		em.persist(field1);
//		Field field2 = new Field();
//		field2.setName("年龄");
//		field2.setFieldGroup(fieldGroup);
//		field2.setFieldType(integerFieldType);
//		em.persist(field2);

//		Content content = new Content();
//		content.setModel(model);
//		content.setWeight(10);
//		em.persist(content);
//
//		FieldValue fieldValue1 = FieldValue.createInstance(content, field1);
//		fieldValue1.setValue("哈哈");
//		em.persist(fieldValue1);
//		FieldValue fieldValue2 = FieldValue.createInstance(content, field2);
//		fieldValue2.setValue("32");
//		em.persist(fieldValue2);
//		Object value2 = fieldValue2.getValue();
//		System.out.println(value2);
	}

	@Test
	public void Test2_showContent() {
		Content content = em.find(Content.class, 1L);
		for (Map.Entry<Field, FieldValue> entry : content.getFieldValues().entrySet()) {
			System.out.println(entry.getValue().getValue());
		}
	}

}
