package org.cdl.demo.core.service.content.aware;

import org.cdl.demo.core.entity.content.Association;
import org.cdl.demo.core.entity.content.AssociationId;
import org.cdl.demo.core.entity.content.Container;
import org.cdl.demo.core.entity.content.Item;
import org.cdl.demo.core.entity.content.aware.ContainerAware;
import org.cdl.demo.core.entity.content.aware.ItemAware;
import org.cdl.demo.core.service.content.AssociationService;

public interface AssociationAwareService {

	AssociationService getAssociationService();

	default void attachAssociation(ItemAware itemAware, ContainerAware containerAware) {
		attachAssociation(itemAware, containerAware, false);
	}

	default void attachAssociation(ItemAware itemAware, ContainerAware containerAware, boolean own) {
		if (itemAware != null && containerAware != null) {
			attachAssociation(itemAware.getItem(), containerAware.getContainer(), own);
		}
	}

	default void attachAssociation(Item item, Container container) {
		if (item != null && container != null) {
			attachAssociation(item.getId(), container.getId(), false);
		}
	}

	default void attachAssociation(Item item, Container container, boolean own) {
		if (item != null && container != null) {
			attachAssociation(item.getId(), container.getId(), own);
		}
	}

	default void attachAssociation(Long itemId, Long containerId) {
		if (itemId != null && containerId != null) {
			attachAssociation(itemId, containerId, false);
		}
	}

	default void attachAssociation(Long itemId, Long containerId, boolean own) {
		if (itemId != null && containerId != null) {
			getAssociationService().save(new Association(itemId, containerId, own));
		}
	}

	default void detachAssociation(ItemAware itemAware, ContainerAware containerAware) {
		if (itemAware != null && containerAware != null) {
			detachAssociation(itemAware.getItem(), containerAware.getContainer());
		}
	}

	default void detachAssociation(Item item, Container container) {
		if (item != null && container != null) {
			detachAssociation(item.getId(), container.getId());
		}
	}

	default void detachAssociation(Long itemId, Long containerId) {
		if (itemId != null && containerId != null) {
			getAssociationService().delete(new AssociationId(itemId, containerId));
		}
	}

}
