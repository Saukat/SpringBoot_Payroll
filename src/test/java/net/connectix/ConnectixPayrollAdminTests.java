package net.connectix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import net.connectix.document.Admin;
import net.connectix.repo.AdminRepository;
import net.connectix.service.IAdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectixPayrollAdminTests {
	
  @Autowired	
  private IAdminService service;
  @MockBean
  private AdminRepository adminRepo;
  
  @Test
  public void getAdminTest() {
	  when(adminRepo.findAll()).thenReturn(Stream
			  .of(new Admin("admin@connectix.net","admin")).collect(Collectors.toList()));
//	  Integer s=service.getAllAdmin().size();
//	  System.out.println("lenth"+s);
	 assertEquals(1, service.getAllAdmin().size());
  }
  
  @Test
  public void getAdminById() {
	  String email="admin@connectix.net";
	  when(adminRepo.findAdminByEmail(email))
	  .thenReturn(Stream.of(new Admin("admin@connectix.net","admin")).collect(Collectors.toList()));

	  System.out.println("lenth"+adminRepo.findAdminByEmail(email).size());

	  assertEquals(1,adminRepo.findAdminByEmail(email).size());

  }
  

  
  
	
	

}
