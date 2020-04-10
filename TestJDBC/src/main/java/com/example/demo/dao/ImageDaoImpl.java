package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.factory.MyConnectionFactory;
import com.example.demo.model.Image;

public class ImageDaoImpl implements ImageDaoInterface{

	private MyConnectionFactory factory = null;
	private Connection connection =null;
	{
		factory=MyConnectionFactory.getConnectionObject();
		
			try {
				connection= factory.getMyConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
	}
	
	public void addImage(Image image) throws SQLException {
		PreparedStatement prepareStatement = connection.prepareStatement("insert into image values (?,?,?)");
		prepareStatement.setString(1, image.getImageId());
		prepareStatement.setString(2, image.getImageUrl());
		prepareStatement.setBoolean(3,image.isAvailable());
		prepareStatement.executeUpdate();
		
	}

	public List<Image> getAllImage() throws SQLException {
		PreparedStatement sqlGetAll = connection.prepareStatement("select * from image");
		ResultSet rs = sqlGetAll.executeQuery();
		List<Image> list = new ArrayList<Image>();
		while(rs.next())
		{
			Image image = new Image();
			String Id = rs.getString(1);
			String url = rs.getString(2);
			boolean isAvailable = rs.getBoolean(3);
			image.setImageId(Id);
			image.setImageUrl(url);
			image.setAvailable(isAvailable);
			list.add(image);
		}
		
		return list;
	}

	public Image getImageByImageUrl(String imageUrl)throws SQLException {
		PreparedStatement sqlGetAll = connection.prepareStatement("select * from image where imageUrl = ?");
		sqlGetAll.setString(1, imageUrl);
		ResultSet rs = sqlGetAll.executeQuery();
		List<Image> list = new ArrayList<Image>();
		while(rs.next())
		{
			Image image = new Image();
			String Id = rs.getString(1);
			String url = rs.getString(2);
			boolean isAvailable = rs.getBoolean(3);
			image.setImageId(Id);
			image.setImageUrl(url);
			image.setAvailable(isAvailable);
			list.add(image);
		}
		
		
		return list.get(0);
	}

	public void deleteImage(String imageUrl)throws SQLException {
		PreparedStatement sqlDelete = connection.prepareStatement("delete from image where imageUrl=?");
		sqlDelete.setString(1,imageUrl);
		System.out.println(sqlDelete.executeUpdate());
		
	}

	public void updateImage(String imageUrl, boolean isAvailable)throws SQLException {
		PreparedStatement sqlUpdate = connection.prepareStatement("update image set isAvailable=? where imageUrl=?");
		sqlUpdate.setBoolean(1,isAvailable);
		sqlUpdate.setString(2, imageUrl);
		System.out.println(sqlUpdate.executeUpdate());
		
	}


}
