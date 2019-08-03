package io.choerodon.choerodonstudyservice24981y.controller;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.choerodonstudyservice24981y.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice24981y.infra.dto.UserDTO;
import io.choerodon.choerodonstudyservice24981y.infra.feign.IamFeignClient;
import io.choerodon.choerodonstudyservice24981y.service.OrganizationService;
import io.choerodon.choerodonstudyservice24981y.service.OrganizationUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class StudyController {

    @Autowired
    IamFeignClient iamFeignClient;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    OrganizationUserService organizationUserService;

    @Permission(type = ResourceType.ORGANIZATION,permissionPublic = true)
    @ApiOperation(value = "调用api插入组织")
    @GetMapping("/insertorg/{id}")
    public ResponseEntity<OrganizationDTO> insertorg(@PathVariable("id") Long id){
        OrganizationDTO organizationDTO = iamFeignClient.getOrgById(id).getBody();
        organizationService.insertOrganzation(organizationDTO);
        return new ResponseEntity<>(organizationService.insertOrganzation(organizationDTO),HttpStatus.OK);
    }

    @Permission(type = ResourceType.ORGANIZATION, permissionPublic = true)
    @ApiOperation(value = "调用api插入用户")
    @GetMapping("/insertuser/{organization_id}/{id}")
    public ResponseEntity<UserDTO> insertUser(@PathVariable(name = "organization_id") Long organizationId,
                                             @PathVariable Long id) {
        UserDTO userDTO = iamFeignClient.getUserById(organizationId,id).getBody();
        userDTO = organizationUserService.insert(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Permission(type = ResourceType.ORGANIZATION, permissionPublic = true)
    @ApiOperation(value = "查询组织")
    @GetMapping("/study/queryorg/{organization_id}")
    public ResponseEntity<OrganizationDTO> queryOrg(@PathVariable(name = "organization_id") Long organizationId) {
        return new ResponseEntity<>(organizationService.queryOrganizationById(organizationId), HttpStatus.OK);
    }


    @Permission(type = ResourceType.ORGANIZATION, permissionPublic = true)
    @ApiOperation(value = "查询组织下的用户")
    @GetMapping("/study/queryuser/{organization_id}/{id}")
    public ResponseEntity<UserDTO> queryUser(@PathVariable(name = "organization_id") Long organizationId,
                                         @PathVariable Long id) {
        return new ResponseEntity<>(organizationUserService.query(organizationId, id), HttpStatus.OK);
    }

}
