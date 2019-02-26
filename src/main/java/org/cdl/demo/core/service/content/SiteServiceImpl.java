package org.cdl.demo.core.service.content;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cdl.demo.core.entity.content.Site;
import org.cdl.demo.core.entity.model.Model;
import org.cdl.demo.core.entity.model.field.FieldType;
import org.cdl.demo.core.repository.content.SiteDao;
import org.cdl.demo.core.repository.content.aware.ContainerAwareDao;
import org.cdl.demo.core.repository.content.aware.ContentAwareDao;
import org.cdl.demo.core.repository.content.aware.NodeAwareDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.Getter;

@Service("siteService")
public class SiteServiceImpl implements SiteService {

	@PersistenceContext
	@Getter
    private EntityManager entityManager;

	@Autowired
	@Getter
	private SiteDao dao;

	@Autowired
	@Getter
	private ContainerService containerService;

	@Autowired
	@Getter
	private ContainerAwareDao<Site> containerAwareDao;

	@Autowired
	@Getter
	private AssociationService associationService;

	@Autowired
	@Getter
	private NodeAwareDao<Site> nodeAwareDao;

	@Autowired
	@Getter
	private NodeService nodeService;

	@Autowired
	@Getter
	private ContentService contentService;

	@Autowired
	@Getter
	private ContentAwareDao<Site> contentAwareDao;

	@Override
	public void save(Site site, Model model, Map<String, String[]> requestParameterMap, Map<String, FieldType<?>> fieldTypeMap) {
		checkPrimary(site);
		attachContainer(site);
		attachNode(site);
		attachContent(site, model, requestParameterMap, fieldTypeMap);
		save(site);
	}

	@Override
	public Site findByPrimaryTrue() {
		return dao.findByPrimaryTrue();
	}

	@Override
	public Site findOneByHost(String host) {
		return dao.findOneByHost(host);
	}

	private void checkPrimary(Site site) {
		Assert.isTrue(
				!site.isPrimary()
						|| !(site.isNew() ? dao.existsByPrimaryTrue() : dao.existsByPrimaryTrueAndIdNot(site.getId())),
				"the chief site with same code must have only one");
	}

}
