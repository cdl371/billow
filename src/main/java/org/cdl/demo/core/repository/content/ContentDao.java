package org.cdl.demo.core.repository.content;

import org.cdl.demo.core.entity.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentDao extends JpaRepository<Content, Long> {

}
