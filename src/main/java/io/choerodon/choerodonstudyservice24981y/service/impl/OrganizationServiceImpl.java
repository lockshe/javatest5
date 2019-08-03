package io.choerodon.choerodonstudyservice24981y.service.impl;

import io.choerodon.choerodonstudyservice24981y.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice24981y.infra.dto.ProjectDTO;
import io.choerodon.choerodonstudyservice24981y.infra.dto.UserDTO;
import io.choerodon.choerodonstudyservice24981y.infra.mapper.OrganizationMapper;
import io.choerodon.choerodonstudyservice24981y.infra.mapper.ProjectMapper;
import io.choerodon.choerodonstudyservice24981y.infra.mapper.UserMapper;
import io.choerodon.choerodonstudyservice24981y.service.OrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationMapper organizationMapper;

    private ProjectMapper projectMapper;

    private UserMapper userMapper;

    public OrganizationServiceImpl(OrganizationMapper organizationMapper, UserMapper userMapper){
        this.organizationMapper = organizationMapper;
        this.userMapper = userMapper;
    }

    @Transactional
    public OrganizationDTO queryOrganizationById(Long organizationId) {
        // OrganizationDTO organizationDTO = organizationAssertHelper.organizationNotExisted(organizationId);
        OrganizationDTO organizationDTO = organizationMapper.selectByPrimaryKey(organizationId);
//        ProjectDTO example = new ProjectDTO();
//        example.setOrganizationId(organizationId);
//        List<ProjectDTO> projects = projectMapper.select(example);
//        organizationDTO.setProjects(projects);
//        organizationDTO.setProjectCount(projects.size());
//
//        Long userId = organizationDTO.getUserId();
//        UserDTO user = userMapper.selectByPrimaryKey(userId);
//        if (user != null) {
//            organizationDTO.setOwnerLoginName(user.getLoginName());
//            organizationDTO.setOwnerRealName(user.getRealName());
//            organizationDTO.setOwnerPhone(user.getPhone());
//            organizationDTO.setOwnerEmail(user.getEmail());
//        }
        return organizationDTO;
    }

    @Override
    public OrganizationDTO insertOrganzation(OrganizationDTO organizationDTO) {
        organizationMapper.insert(organizationDTO);
        return organizationDTO;
    }
}
