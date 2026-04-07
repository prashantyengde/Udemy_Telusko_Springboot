package com.telusko.service;

import java.util.List;

import com.telusko.entity.Product;
import com.telusko.view.ResultView;

public interface IProductService 
{
	List<ResultView> searchByPriceLessThan(Double price);

}
