package Entity;

import java.sql.Date;
import java.util.List;

public class Book {
	private String Name;
	private String ID;
	private List<String>Author;
	private String PublishingHouse;
	private Date PublishYear;
	private Date StorageTime;
	private String StoragePlace;
	private float Price;
	private int Amount;
	private String Category;
	private String BrefIntroduction;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public List<String> getAuthor() {
		return Author;
	}
	public void setAuthor(List<String> author) {
		Author = author;
	}
	public String getPublishingHouse() {
		return PublishingHouse;
	}
	public void setPublishingHouse(String publishingHouse) {
		PublishingHouse = publishingHouse;
	}
	public Date getPublishYear() {
		return PublishYear;
	}
	public void setPublishYear(Date publishYear) {
		PublishYear = publishYear;
	}
	public Date getStorageTime() {
		return StorageTime;
	}
	public void setStorageTime(Date storageTime) {
		StorageTime = storageTime;
	}
	public String getStoragePlace() {
		return StoragePlace;
	}
	public void setStoragePlace(String storagePlace) {
		StoragePlace = storagePlace;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getBrefIntroduction() {
		return BrefIntroduction;
	}
	public void setBrefIntroduction(String brefIntroduction) {
		BrefIntroduction = brefIntroduction;
	}
}
