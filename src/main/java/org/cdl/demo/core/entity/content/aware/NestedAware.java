package org.cdl.demo.core.entity.content.aware;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;

import org.cdl.demo.core.entity.Base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class NestedAware extends Base {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	private NestedAware parent;

	@OneToMany(mappedBy = "parent")
	private List<NestedAware> children;

	@Column(columnDefinition = "bit default 1")
	private boolean leaf = true;

	public void setParent(NestedAware parent) {
		NestedAware oldParent = this.getParent();
		if (oldParent != null && oldParent != parent && oldParent.getChildren().size() <= 1) {
			oldParent.setLeaf(true);
		}
		if (parent != null) {
			parent.setLeaf(false);
		}
		this.parent = parent;
	}

	@PreUpdate
	private void preUpdate() {
		checkParent(this, this.getId());
	}

	private static void checkParent(NestedAware node, Long id) {
		if (node.getParent() != null) {
			if (node.getParent().getId() == id) {
				throw new IllegalArgumentException("ancestor id must not include the node id");
			} else {
				checkParent(node.getParent(), id);
			}
		}
	}

}
