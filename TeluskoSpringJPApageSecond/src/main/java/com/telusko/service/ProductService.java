package com.telusko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.telusko.entity.Product;
import com.telusko.repo.IProductRepo;

@Service
public class ProductService implements IProductService
{
	
	@Autowired
	private IProductRepo repo;

	@Override
	public Iterable<Product> fetchProductInfoSorting(boolean status, String... properties) {
		Sort sort=Sort.by(status?Direction.ASC:Direction.DESC, properties);
		
		return repo.findAll(sort);
		
	}

	@Override
	public Iterable<Product> fetchProductByPagination(int pgNo, int pgSize, boolean status, String... properties) {
		
		Sort sort=Sort.by(status?Direction.ASC:Direction.DESC, properties);

		PageRequest pageable = PageRequest.of(pgNo, pgSize, sort);
		Page<Product> page= repo.findAll(pageable);
		return page.getContent();
		
	}

	@Override
	public void fetchProductByPagination(int pgSize)
	{
		System.out.println("*************INSIDE 3RD method************************");
		long count=5l;
		long pagecount= count/pgSize; //==> 12/3 ==> 4
		//14/5 ==> 2.8 ==> 2 ==> 3
		//14%5 == 0 ? increment pagecount
		//14%2 == 0 ? keep pagecount
		System.out.println("pagecount 1---> "+ pagecount );
		pagecount = count%pgSize==0?pagecount:++pagecount;
		System.out.println("pagecount 2---> "+ pagecount );
		
		for(int i=0;i<pagecount; i++)
		{
			PageRequest pageable=PageRequest.of(i, pgSize);
			System.out.println("pageable 3---> "+ pageable );
			Page<Product> page = repo.findAll(pageable);
			page.getContent().forEach(p->System.out.println(p));
			System.out.println("**************************************");
		}
		
		
		
		
		
		
	}

}
