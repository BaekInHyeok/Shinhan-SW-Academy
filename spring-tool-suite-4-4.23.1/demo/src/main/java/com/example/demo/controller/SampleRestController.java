package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.CarVO;

@RestController
@RequestMapping("/sample")
public class SampleRestController {
	
	@GetMapping("/test1")
	public String f1() {
		return "HI";
	}
	
	@GetMapping("/test2")
	public CarVO f2() {
		CarVO carVO = CarVO.builder()
				.Model("ABC모델")
				.price(2000)
				.build();
		
		return carVO;
	}
	@GetMapping("/test3")
	public List<CarVO> f3() {
		List<CarVO> carList = new ArrayList<>();
		IntStream.rangeClosed(1, 5).forEach(i->{
			CarVO carVO = CarVO.builder()
					.Model("ABC모델"+i)
					.price(2000*i)
					.build();
			carList.add(carVO);
		});
		
		
		return carList;
	}
}
