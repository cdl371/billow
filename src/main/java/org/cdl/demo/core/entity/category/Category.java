package org.cdl.demo.core.entity.category;

public interface Category {

	public String getName();

	public String getCode();

	/**
	 * true: 可置于站点容器中
	 */
	public boolean isShared();

}
