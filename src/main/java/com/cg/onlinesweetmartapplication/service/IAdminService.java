package com.cg.onlinesweetmartapplication.service;

import java.util.List;

import com.cg.onlinesweetmartapplication.entities.Admin;
import com.cg.onlinesweetmartapplication.exceptions.AdminNotFoundException;
import com.cg.onlinesweetmartapplication.model.AdminDTO;

public interface IAdminService {
	public AdminDTO addAdmin(Admin admin);
	public AdminDTO updateAdmin(Admin admin) throws AdminNotFoundException;
	public AdminDTO cancelAdmin(int adminId) throws AdminNotFoundException;
	public List<AdminDTO> showAllAdmins();
	public List<AdminDTO> showAllAdmins(int adminId);
}
