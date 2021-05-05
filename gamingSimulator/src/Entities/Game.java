package Entities;

import Abstract.Entity;

public class Game implements Entity{
	
	private int gameId;
	private String gameName;
	private String gameDetails;
	private String allReviews;
	private String releaseDate;
	private double price;
	
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getGameDetails() {
		return gameDetails;
	}
	public void setGameDetails(String gameDetails) {
		this.gameDetails = gameDetails;
	}
	public String getAllReviews() {
		return allReviews;
	}
	public void setAllReviews(String allReviews) {
		this.allReviews = allReviews;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
