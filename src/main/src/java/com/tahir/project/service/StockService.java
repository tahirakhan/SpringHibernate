package com.tahir.project.service;

import com.tahir.project.model.Stock;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface StockService {
  Stock save(Stock stock);
  Stock update(Stock stock);
  void delete(Integer  stockId);
  Stock findByStockId(Integer stockId);
  public List<Stock> findAll();
}
