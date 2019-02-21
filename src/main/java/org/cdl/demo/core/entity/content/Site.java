package org.cdl.demo.core.entity.content;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.cdl.demo.core.entity.Base;
import org.cdl.demo.core.entity.content.aware.ContainerAware;
import org.cdl.demo.core.entity.content.aware.ContentAware;
import org.cdl.demo.core.entity.content.aware.NodeAware;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Site extends Base implements ContentAware, ContainerAware, NodeAware {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String name;
	@NonNull
	@Column(unique = true)
	private String path;
	@NonNull
	private String host;
	private String alias;
	private String redirect;
	@Column(columnDefinition = "bit default 1")
	private boolean active = true;
	@Column(columnDefinition = "bit default 0")
	private boolean primary = false;

	@NonNull
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Content content;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false, updatable = false)
	private Container container;

	@NonNull
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false, updatable = false)
	private Node node;

}
