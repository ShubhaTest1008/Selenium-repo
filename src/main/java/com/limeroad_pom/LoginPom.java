package com.limeroad_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom {
	public WebDriver driver;

	public LoginPom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath="//span[text()='SHOP MEN']")
//	private WebElement ShopMenBtn;
//		public WebElement getShopMenBtn() {
//		return ShopMenBtn;
//	}

	@FindBy(id = "shopWomen")
	private WebElement ShopWomenBtn;

	public WebElement getShopWomenBtn() {
		return ShopWomenBtn;
	}

	@FindBy(xpath = "//a[@id='women_category']//child::div")
	private WebElement womenModuleBtn;

	public WebElement getwomenModuleBtn() {
		return womenModuleBtn;
	}
	
	@FindBy(xpath="(//div[@class='dT wp100 bs tlF wsR'])[1]//child::div[@class='fs14 p48 pR']//child::a[text()='earrings']")
	private WebElement earringsBtn;
	
	public WebElement getearringsBtn() {
		return earringsBtn;
	}
	
	@FindBy(xpath="(//div[@class='prdC bgF br4 fs12 fg2t dIb vT pR taC bs bd2E   m6'])[2]//child::a[@data-prod-id='17759880']")
	private WebElement Earrings1;
	
	public WebElement getEarrings1() {
		return Earrings1;
	}
	
	@FindBy(xpath="//div[text()='ADD TO CART']")
	private WebElement AddToCartBtn;
	
	public WebElement getAddToCartBtn() {
		return AddToCartBtn;
	}
}
