package com.example.demo.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Image {
	
	private String imageId;
	private String imageUrl;
	private boolean isAvailable;
	
	public Image(String imageUrl,boolean isAvailable)
	{
		this.imageId = UUID.randomUUID().toString();
		this.imageUrl = imageUrl;
		this.isAvailable = isAvailable;
	}
}
