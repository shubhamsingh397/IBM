package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Image;

public interface ImageDaoInterface {

	public void addImage(Image image) throws SQLException;
	public List<Image> getAllImage()throws SQLException;
	public Image getImageByImageUrl(String imageUrl)throws SQLException;
	public void deleteImage(String imageUrl)throws SQLException;
	public void updateImage(String imageUrl,boolean isAvailable)throws SQLException;
}
