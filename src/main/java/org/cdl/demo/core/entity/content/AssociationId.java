package org.cdl.demo.core.entity.content;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociationId implements Serializable {

	private static final long serialVersionUID = 1L;

	private long itemId;

	private long containerId;

}
