package org.cdl.demo.core.service.content;

import org.cdl.demo.core.entity.content.Site;
import org.cdl.demo.core.entity.model.Model;
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
	public void save(Site site, Model model) {
		checkChief(site);
		attachContainer(site);
		attachNode(site);
		attachContent(site, model);
//		if (site.getId() == null) {
//			site.setContent(new Content(modelService.findById(model_id)));
//		} else {
//			Site old = findById(site.getId());
//			site.setContent(old.getContent());
//		}
		dao.save(site);
	}

	@Override
	public Site findByChiefTrue() {
		return dao.findByChiefTrue();
	}

	@Override
	public Site findOneByDomain(String domain) {
		return dao.findOneByDomain(domain);
	}

	private void checkChief(Site site) {
		Assert.isTrue(
				!site.isChief()
						|| !(site.isNew() ? dao.existsByChiefTrue() : dao.existsByChiefTrueAndIdNot(site.getId())),
				"the chief site with same code must have only one");
	}

}
