package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Image;
import com.example.demo.dao.ImageDao;
@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImageDao dao;
	@Override
	public void createImage(Image image) {
		dao.createImage(image);
		
	}

	@Override
	public List<Image> listImage() {
		return dao.listImagebyJdbcRowMapper();
	}

	@Override
	public void updateById(String imageId, String imageUrl) {
		// TODO Auto-generated method stub
		dao.updateById(imageId, imageUrl);
	}

	@Override
	public void deleteById(String imageId) {
		// TODO Auto-generated method stub
		dao.deleteById(imageId);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dao.deleteAll();
	}

}
