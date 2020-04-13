package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.bean.Image;

public class ImageMapper implements RowMapper<Image> {

	@Override
	public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Image image = new Image();
		image.setImageId(rs.getString("imageId"));
		image.setImageUrl(rs.getString("imageUrl"));
		return image;
	}

}
