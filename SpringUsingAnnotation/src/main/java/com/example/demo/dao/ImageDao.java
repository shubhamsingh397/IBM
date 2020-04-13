package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.Image;

public interface ImageDao {

	public void createImage(Image image);
	public List<Image> listImage();
	public List<Image> listImagebyJdbcRowMapper();
	public void updateById(String imageId,String imageUrl);
	public void deleteById(String imageId);
	public void deleteAll();
}
