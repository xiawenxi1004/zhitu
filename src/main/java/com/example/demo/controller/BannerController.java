package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Banner;
import com.example.demo.service.BannerService;

@Controller
public class BannerController {
	private BannerService bannerService;
	@GetMapping("/getImages")
	public String getImages() {
		List<Banner> images = bannerService.getImages();
		return null;
	}
}
