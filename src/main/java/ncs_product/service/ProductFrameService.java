package ncs_product.service;

import java.sql.SQLException;
import java.util.List;

import ncs_product.dao.ProductMapper;
import ncs_product.dao.ProductMapperImpl;
import ncs_product.dao.SaleMapper;
import ncs_product.dao.SaleMapperImpl;
import ncs_product.dto.Product;
import ncs_product.dto.Sale;


public class ProductFrameService {
	private SaleMapper saleDao;
	private ProductMapper productDao;
	
	public ProductFrameService() {
		saleDao = new SaleMapperImpl();
		productDao = new ProductMapperImpl(); 
	} 
	
	public List<Sale> selectSaleByAll() throws SQLException {
		return saleDao.selectProductByAll();
	}
	
	public int registerSale(Sale s) throws SQLException {
		return saleDao.insertSale(s);
	}
	
	public Product searchProduct(Product product) throws SQLException {
		return productDao.selectProductByNo(product);
	}
}
