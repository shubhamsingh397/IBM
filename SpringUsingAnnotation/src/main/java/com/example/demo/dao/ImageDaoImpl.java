package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Image;



@Repository
public class ImageDaoImpl implements ImageDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public void createImage(Image image) {

		String sql = "insert into image values (?,?)";
		template.update(sql,new  Object[] {image.getImageId(),image.getImageUrl()});
		
	}

	@Override
	public List<Image> listImage() {
		// TODO Auto-generated method stub
		String sql = "select * from image";
		List<Image> list = template.query(sql, new ImageMapper());
		return list;
	}
	public List<Image> listImagebyJdbcRowMapper() {
		// TODO Auto-generated method stub
		String sql = "select * from image";
		List<Image> list = template.query(sql, new BeanPropertyRowMapper<Image>(Image.class));
		return list;
	}

	@Override
	public void updateById(String imageId,String imageUrl) {
		// TODO Auto-generated method stub
		String sql = "update image set imageUrl = ? where imageId = ?";
		
		int update = template.update(sql, new Object[] {imageUrl,imageId});
		if(update ==0)
			System.out.println("No Id found = "+imageId);
		else
			System.out.println("Data updated with imageId = "+imageId);
	}

	@Override
	public void deleteById(String imageId) {
		// TODO Auto-generated method stub
String sql = "delete from image where imageId = ?";
		
		int update = template.update(sql, new Object[] {imageId});
		if(update ==0)
			System.out.println("No Id found = "+imageId);
		else
			System.out.println("Data deleted with imageId = "+imageId);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
String sql = "delete from image ";
		
		template.update(sql);
	}
	
	/*
	 * private DataSource dataSource;
	 * 
	 * @Autowired public ImageDaoImpl(DataSource dataSource) { super();
	 * this.dataSource = dataSource; }
	 * 
	 * private Connection connection=null;;
	 * 
	 * private static Logger logger=Logger.getLogger("ImageDaoImpl");
	 * 
	 * @Override public Image createImage(Image image) { // TODO Auto-generated
	 * method stub try { logger.log(Level.INFO, "connecting to database");
	 * connection=dataSource.getConnection(); logger.log(Level.INFO, "connected");
	 * PreparedStatement
	 * pStatement=connection.prepareStatement("insert into image values(?,?)");
	 * pStatement.setString(1,image.getImageId()); pStatement.setString(2,
	 * image.getImageUrl()); pStatement.executeUpdate(); logger.log(Level.INFO,
	 * "image creation completed"); } catch (Exception e) { logger.log(Level.SEVERE,
	 * "unable to connect db"); e.printStackTrace();
	 * 
	 * } return image; }
	 * 
	 * @Override public List<Image> listImage() { try { logger.log(Level.INFO,
	 * "connecting to database"); connection=dataSource.getConnection();
	 * logger.log(Level.INFO, "connected"); PreparedStatement
	 * pStatement=connection.prepareStatement("select * from image");
	 * 
	 * ResultSet rs = pStatement.executeQuery(); List<Image> list = new
	 * ArrayList<Image>(); while(rs.next()) {
	 * 
	 * Image image = new Image(); String Id = rs.getString(1); String url =
	 * rs.getString(2);
	 * 
	 * image.setImageId(Id); image.setImageUrl(url);
	 * 
	 * list.add(image); } logger.log(Level.INFO, "image list extracted"); return
	 * list;
	 * 
	 * 
	 * } catch (Exception e) { logger.log(Level.SEVERE, "unable to connect db");
	 * e.printStackTrace();
	 * 
	 * } return null; }
	 */
	
	
	}


