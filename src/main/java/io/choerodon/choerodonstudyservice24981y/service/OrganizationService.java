package io.choerodon.choerodonstudyservice24981y.service;

import io.choerodon.choerodonstudyservice24981y.infra.dto.OrganizationDTO;


public interface OrganizationService {

    OrganizationDTO queryOrganizationById(Long organizationId);

    OrganizationDTO insertOrganzation(OrganizationDTO organizationDTO);


}
