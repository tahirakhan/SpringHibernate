package com.tahir.project.model;

/**
 * Created by Tahir on 3/7/15.
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", catalog = "test", uniqueConstraints = {
    @UniqueConstraint(columnNames = "STOCK_NAME"),
    @UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements java.io.Serializable {


  private Integer stockId;

  private String stockCode;

  private String stockName;

  public Stock() {
  }

  public Stock(String stockCode, String stockName) {
    this.stockCode = stockCode;
    this.stockName = stockName;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "STOCK_ID", unique = true, nullable = false)
  public Integer getStockId() {
    return stockId;
  }

  public void setStockId(Integer stockId) {
    this.stockId = stockId;
  }
  @Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
  public String getStockCode() {
    return stockCode;
  }

  public void setStockCode(String stockCode) {
    this.stockCode = stockCode;
  }
  @Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
  public String getStockName() {
    return stockName;
  }

  public void setStockName(String stockName) {
    this.stockName = stockName;
  }
}