package ncs_product.dao;

import java.sql.SQLException;
import java.util.List;

import ncs_product.dto.Product;


public interface ProductMapper {
	
	List<Product> selectProductByAll();
	
	int insertProduct(Product product) throws SQLException;
	int updateProduct(Product product) throws SQLException;
	int deleteProduct(Product product) throws SQLException;
	Product selectProductByNo(Product product) throws SQLException;
	
	
}
