package org.firstzone.section6;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shinhan.myapp.section6.ComputerVO;

import lombok.Data;

@Component
@Data
public class CompanyVO {
	String compName;
	String address;
	List<ComputerVO> computerList;
}
