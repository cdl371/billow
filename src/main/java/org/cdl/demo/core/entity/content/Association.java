package org.cdl.demo.core.entity.content;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

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
@IdClass(AssociationId.class)
public class Association implements Serializable {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Id
	private Long itemId;

	@NonNull
	@Id
	private Long containerId;

	@Column(columnDefinition = "bit default 0")
	private boolean own = false;

}
