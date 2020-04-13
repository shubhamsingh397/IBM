package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Image;

public interface ImageService {
	public void createImage(Image image);
	public List<Image> listImage();
	
	public void updateById(String imageId,String imageUrl);
	public void deleteById(String imageId);
	public void deleteAll();
}
