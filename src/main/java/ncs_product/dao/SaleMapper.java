package ncs_product.dao;

import java.sql.SQLException;
import java.util.List;

import ncs_product.dto.Sale;


public interface SaleMapper {
	
	List<Sale> selectProductByAll() throws SQLException;
	
	List<Sale> selectProductRank(boolean isSale) throws SQLException;
	
	int insertSale(Sale sale) throws SQLException;
}
