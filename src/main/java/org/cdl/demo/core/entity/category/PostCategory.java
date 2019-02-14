package org.cdl.demo.core.entity.category;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(100)
public class PostCategory implements Category {

	public static final String CODE = "post";

	@Override
	public String getName() {
		return "文章";
	}

	@Override
	public String getCode() {
		return CODE;
	}

	@Override
	public boolean isShared() {
		return true;
	}

}
