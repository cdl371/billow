package org.cdl.demo.core.repository.content;

import org.cdl.demo.core.entity.content.Association;
import org.cdl.demo.core.entity.content.AssociationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociationDao extends JpaRepository<Association, AssociationId> {

	Association findByItemId(Long itemId);

	Association findByItemIdAndOwnTrue(Long itemId);

	Association findByItemIdAndOwnFalse(Long itemId);

	Association findByContainerId(Long containerId);

}
