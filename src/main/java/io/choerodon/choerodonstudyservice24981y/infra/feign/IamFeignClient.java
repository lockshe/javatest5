package io.choerodon.choerodonstudyservice24981y.infra.feign;

import feign.Headers;
import io.choerodon.choerodonstudyservice24981y.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice24981y.infra.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("iam-service")
public interface IamFeignClient {

    @GetMapping("/v1/organizations/{organization_id}")
    ResponseEntity<OrganizationDTO> getOrgById(@PathVariable("organization_id")long id);

    @GetMapping("/v1/organizations/{organization_id}/users/{user_id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable(name = "organization_id") Long organizationId,
                                        @PathVariable(name = "user_id") Long id);

}
