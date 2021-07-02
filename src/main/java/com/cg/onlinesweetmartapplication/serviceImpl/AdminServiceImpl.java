package com.cg.onlinesweetmartapplication.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinesweetmartapplication.entities.Admin;
import com.cg.onlinesweetmartapplication.entities.Cart;
import com.cg.onlinesweetmartapplication.entities.Customer;
import com.cg.onlinesweetmartapplication.entities.Product;
import com.cg.onlinesweetmartapplication.entities.SweetItem;
import com.cg.onlinesweetmartapplication.entities.User;
import com.cg.onlinesweetmartapplication.exceptions.AdminNotFoundException;
import com.cg.onlinesweetmartapplication.model.AdminDTO;
import com.cg.onlinesweetmartapplication.repository.IAdminRepository;
import com.cg.onlinesweetmartapplication.service.IAdminService;
import com.cg.onlinesweetmartapplication.utils.AdminUtils;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	public IAdminRepository repository;
	@Override
	public AdminDTO addAdmin(Admin admin) {
		AdminDTO adminDTO;
		if (admin == null)
			adminDTO =  null;
		else 
			adminDTO = AdminUtils.convertToAdminDto(repository.save(admin));
		return adminDTO;
	}

	@Override
	public AdminDTO updateAdmin(Admin admin) throws AdminNotFoundException {
		AdminDTO adminDTO;
		if (admin == null)
			adminDTO = null;
		Admin existingAdmin = repository.findById(admin.getId()).orElse(null);
		if (existingAdmin == null) {
			throw new AdminNotFoundException("Invalid id.");
		}
		else {
			adminDTO =  AdminUtils.convertToAdminDto(repository.save(admin));
		}
		return adminDTO;
	}

	@Override
	public AdminDTO cancelAdmin(int adminId) throws AdminNotFoundException {
		Admin existingAdmin = repository.findById(adminId).orElse(null);
		if (existingAdmin == null) {
			throw new AdminNotFoundException("Invalid id.");
		}
		else {
			repository.delete(existingAdmin);
			return AdminUtils.convertToAdminDto(existingAdmin);
		}
	}

	@Override
	public List<AdminDTO> showAllAdmins() {
		List<Admin> listAdmins = repository.findAll();
		return AdminUtils.convertToAdminDtoList(listAdmins);
	}

	@Override
	public List<AdminDTO> showAllAdmins(int adminId) {
		List<Admin> listAdmins = new ArrayList<Admin>();
		Optional<Admin> adminOptional = repository.findById(adminId);
		if (adminOptional.isPresent())
			listAdmins.add(adminOptional.get());
		return AdminUtils.convertToAdminDtoList(listAdmins);
	}
	
	
	public static boolean validateAdmin(Admin admin) {
		boolean flag;
		if (!(validateId(admin) &&  validateUser(admin) &&  validateSweetItem(admin) &&  validateCart(admin) &&  validateProduct(admin))) {
			flag = false;
		}
		else {
			flag = true;
		}
		return flag;
	}
	
	
	public static boolean validateId(Admin admin) {
		boolean flag;
		int id;
		AdminServiceImpl service = new AdminServiceImpl(); 
		if (admin == null ) {
			flag = false;
		}
		else {
			id = admin.getId();
			if (id < 0 && service.repository.existsById(id)) {
				flag = false;
			}
			else {
				flag = true;
			}
		}
		return flag;
	}
	

	
//	public static boolean validateCustomer(Admin admin) {
//		boolean flag;
//		if (admin == null ) {
//			flag = false;
//		}
//		else {
//			Customer customer = admin.getCustomer();
//			if (customer == null)
//				flag = false;
//			else
//				flag = true;
//		}
//		return flag;
//	}
	
	public static boolean validateUser(Admin admin) {
		boolean flag;
		if (admin == null ) {
			flag = false;
		}
		else {
			User user = admin.getUser();
			if (user == null)
				flag = false;
			else
				flag = true;
		}
		return flag;
	}
	public static boolean validateSweetItem(Admin admin) {
		boolean flag;
		if (admin == null ) {
			flag = false;
		}
		else {
			SweetItem sweetItem = admin.getItem();
			if (sweetItem == null)
				flag = false;
			else
				flag = true;
		}
		return flag;
	}
	
	
	public static boolean validateCart(Admin admin) {
		boolean flag;
		if (admin == null ) {
			flag = false;
		}
		else {
			Cart cart = admin.getCart();
			if (cart == null)
				flag = false;
			else
				flag = true;
		}
		return flag;
	}
	
	public static boolean validateProduct(Admin admin) {
		boolean flag;
		if (admin == null ) {
			flag = false;
		}
		else {
			Product product = admin.getProduct();
			if (product == null)
				flag = false;
			else
				flag = true;
		}
		return flag;
	}
	
}
