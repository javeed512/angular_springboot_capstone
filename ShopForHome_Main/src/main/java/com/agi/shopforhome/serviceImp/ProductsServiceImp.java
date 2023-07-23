package com.agi.shopforhome.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agi.shopforhome.dto.ProductsDTO;
import com.agi.shopforhome.entity.Products;
import com.agi.shopforhome.helper.Helper;
import com.agi.shopforhome.repository.ProductsRepository;
import com.agi.shopforhome.service.IProductsService;

/**
 * @author hakeem
 * Modified Date: 24-08-2022
 * Description:Product service class
 * 
 *
 */

@Service
public class ProductsServiceImp implements IProductsService {
	
	@Autowired
	private ProductsRepository repo;

	/**
	 * @author  hakeem
	 * Modified Date: 24-08-2022
	 * Description: to add products
	 * Return Type: String
	 * Params: ProductDTO object
	 */	

	@Override
	public String addProducts(ProductsDTO productDto) {
		// TODO Auto-generated method stub
		Products products=new Products();
		products.setName(productDto.getName());
		products.setPrice(productDto.getPrice());
		products.setUrl(productDto.getUrl());
		products.setQuantity(productDto.getQuantity());
		products.setCatagory(productDto.getCatagory());
		repo.save(products);
		
		
		return "New Product Is Saved";
	}

	/**
	 * @author  hakeem
	 * Modified Date: 24-08-2022
	 * Description: to add admin
	 * Return Type: List of Products
	 * Params: NA
	 */	

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

	/**
	 * @author  hakeem
	 * Modified Date: 24-08-2022
	 * Description: to add admin
	 * Return Type: List of sorted products
	 * Params:NA
	 */	
	
	@Override
	public List<Products> getSortedProduct(){
		return repo.findAll(Sort.by("catagory"));
	}


	/**
	 * @author  hakeem
	 * Modified Date: 24-08-2022
	 * Description: to update product
	 * Return Type: String
	 * Params: ProductDTO object
	 */	
	@Override
	public String updateProducts(ProductsDTO productDto) {
		// TODO Auto-generated method stub
		Products products=new Products();
		products.setId(productDto.getId());
		products.setName(productDto.getName());
		products.setPrice(productDto.getPrice());
		products.setUrl(productDto.getUrl());
		products.setQuantity(productDto.getQuantity());
		products.setCatagory(productDto.getCatagory());
		repo.save(products);
		return "Product is Updated";
	}
	

	/**
	 * @author  hakeem
	 * Modified Date: 24-08-2022
	 * Description: to delete product
	 * Return Type: String
	 * Params: long id
	 */	

	@Override
	public String deleteProducts(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Product is Deleted";
	}

	/**
	 * @author Soumyadeep
	 * Modified Date: 24-08-2022
	 * Description: to get product by id
	 * Return Type: Products object
	 * Params: long id
	 */	

	@Override
	public Products getProductById(long id) {
		return repo.findById(id).get();
		
	}

	/**
	 * @author  hakeem
	 * Modified Date: 24-08-2022
	 * Description: to save bulk product
	 * Return Type: void
	 * Params: Multipart file object
	 */	

	@Override
	public void saveMultiple(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
		List<Products> products= Helper.convertExcelToListOfProducts(file.getInputStream());
		this.repo.saveAll(products);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
