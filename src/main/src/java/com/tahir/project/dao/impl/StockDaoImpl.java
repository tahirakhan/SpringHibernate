package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.StockDao;
import com.tahir.project.model.Stock;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class StockDaoImpl extends AbstractDao implements StockDao {

  @Override
  public Stock save(Stock stock) {
    getSession().save(stock);
    persist(stock);
    return stock;
  }

  @Override
  public Stock update(Stock stock) {
    getSession().update(stock);
    return stock;
  }

  @Override
  public void delete(Integer stockId) {
    Query query = getSession().createSQLQuery("delete from Stock where STOCK_ID = :stockId");
    query.setInteger("stockId", stockId);
    query.executeUpdate();
  }

  @Override
  public Stock findByStockId(Integer STOCK_ID) {
    Criteria criteria = getSession().createCriteria(Stock.class);
    criteria.add(Restrictions.eq("stockId",STOCK_ID));
    return (Stock) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<Stock> findAll() {
    Criteria criteria = getSession().createCriteria(Stock.class);
    return (List<Stock>) criteria.list();
  }
}
