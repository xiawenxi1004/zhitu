package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BannerMapper;
import com.example.demo.model.Banner;
import com.example.demo.model.BannerExample;

@Service
public class BannerServiceImpl  implements BannerService{
		@Autowired
		private BannerMapper bannerMapper;

		@Override
		public List<Banner> getImages() {
			BannerExample example=new BannerExample();
			List<Banner> banners = bannerMapper.selectByExample(example);
			return banners;
		}
		
}
