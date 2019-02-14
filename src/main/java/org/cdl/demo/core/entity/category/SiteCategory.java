package org.cdl.demo.core.entity.category;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(200)
public class SiteCategory implements Category {

	public static final String CODE = "site";

	@Override
	public String getName() {
		return "站点";
	}

	@Override
	public String getCode() {
		return CODE;
	}

	@Override
	public boolean isShared() {
		return false;
	}

}
