package ncs_product.service;

import java.sql.SQLException;
import java.util.List;

import ncs_product.dao.SaleMapper;
import ncs_product.dao.SaleMapperImpl;
import ncs_product.dto.Sale;

public class SalePriceTableUiService {
	private SaleMapper dao;

	public SalePriceTableUiService() {
		dao = new SaleMapperImpl();
	}
	
	public List<Sale> outputOrder(boolean isSale) throws SQLException{
		return dao.selectProductRank(isSale);
	}
}
