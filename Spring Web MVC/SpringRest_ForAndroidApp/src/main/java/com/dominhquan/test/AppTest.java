package com.dominhquan.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dominhquan.model.Account;
import com.dominhquan.model.Item;
import com.dominhquan.service.AccountServiceImpl;
import com.dominhquan.service.ItemServiceImpl;
import com.dominhquan.service.MailService;

public class AppTest {
	
	
	public static void main(String args[]){
		
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("servlet-context.xml");
		AccountServiceImpl accountServiceImpl=(AccountServiceImpl) context.getBean("accountService");
		ItemServiceImpl itemServiceImpl= (ItemServiceImpl) context.getBean("itemService");
		MailService mailService=(MailService) context.getBean("mailService");
		
		/**
		 * 
		 */
//		mailService.sendMail("dominhquan.uit@gmail.com","appgame.cotuong@gmail.com", "Spring Mail Subject","Spring Mail Data");
//		mailService.sendMail("appgame.cotuong@gmail.com","dominhquan.uit@gmail.com", "Spring Mail Subject","https://www.facebook.com/");
		  /**
		   * Account
		   */
		Account account=new Account();
		account.setEmail("dominhquan.uit@gmail.com");
		account.setName("Đỗ Minh Quân");
		account.setPassword("123456");
//		accountServiceImpl.add(account);
		mailService.sendActivationEmail(account, "appgame.cotuong@gmail.com");
//		
//		account=accountServiceImpl.getAccount("dominhquan.uit@gmail.com");
//		if(account!=null){
//			System.out.println(account.getPassword());
//		}else{
//			System.out.println("Fail");
//		}
			/**
			 * Item
			 */
		Item item=itemServiceImpl.getItem("food1");
		item.setStatus(1);
		item.setCreateDate(new Date());
		item.setUpdateDate(new Date());
		itemServiceImpl.updateItem(item);
//		for(int i=1;i<21;i++){
//			Item item=new Item();
//			item.setId("food"+i);
//			item.setName("Food-"+i);
//			item.setRestaurant_name("Restaurant-"+i);
//			item.setCreateDate(new Date());
//			item.setUpdateDate(new Date());
//			item.setPrice(new Double(125.50*i));
//			itemServiceImpl.createItem(item);
//		}
//		List<Item> list=itemServiceImpl.getListItem("Restaurant");
//		for (Item item : list) {
//			System.out.println(item.toString());
//		}
	}
}
