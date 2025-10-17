package com.training.springboot.beans.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrganizationInfo {
    @Value("${org.emp.count:55}")
	private int orgEmpCount;
    @Value("${org.dept.names}")
    private List<String> deptNames;

	public List<String> getDeptNames() {
		return deptNames;
	}

	public void setDeptNames(List<String> deptNames) {
		this.deptNames = deptNames;
	}

	public int getOrgEmpCount() {
		return orgEmpCount;
	}

	public void setOrgEmpCount(int orgEmpCount) {
		this.orgEmpCount = orgEmpCount;
	}
    
}
