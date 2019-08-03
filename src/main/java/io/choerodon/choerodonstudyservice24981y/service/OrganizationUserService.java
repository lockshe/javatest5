package io.choerodon.choerodonstudyservice24981y.service;

import io.choerodon.choerodonstudyservice24981y.infra.dto.UserDTO;

public interface OrganizationUserService {

    UserDTO query(Long organizationId, Long id);

    UserDTO insert(UserDTO userDTO);
}
