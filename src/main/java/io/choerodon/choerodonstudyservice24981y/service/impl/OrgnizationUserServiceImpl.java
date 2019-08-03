package io.choerodon.choerodonstudyservice24981y.service.impl;

import io.choerodon.choerodonstudyservice24981y.infra.dto.UserDTO;
import io.choerodon.choerodonstudyservice24981y.infra.mapper.UserMapper;
import io.choerodon.choerodonstudyservice24981y.service.OrganizationUserService;
import org.springframework.stereotype.Service;

@Service
public class OrgnizationUserServiceImpl implements OrganizationUserService {

    private UserMapper userMapper;

    public OrgnizationUserServiceImpl (UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO query(Long organizationId, Long id) {
        // organizationAssertHelper.organizationNotExisted(organizationId);
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserDTO insert(UserDTO userDTO) {
        userMapper.insert(userDTO);
        return userDTO;
    }
}
