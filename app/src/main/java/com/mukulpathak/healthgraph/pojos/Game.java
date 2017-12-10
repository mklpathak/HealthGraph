package com.mukulpathak.healthgraph.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Game{

	@SerializedName("header_image")
	private String headerImage;

	@SerializedName("short_description")
	private String shortDescription;

	@SerializedName("supported_languages")
	private String supportedLanguages;

	@SerializedName("legal_notice")
	private String legalNotice;

	@SerializedName("achievements")
	private Achievements achievements;

	@SerializedName("developers")
	private List<String> developers;

	@SerializedName("metacritic")
	private Metacritic metacritic;

	@SerializedName("steam_appid")
	private int steamAppid;

	@SerializedName("pc_requirements")
	private PcRequirements pcRequirements;

	@SerializedName("price_overview")
	private PriceOverview priceOverview;

	@SerializedName("type")
	private String type;

	@SerializedName("controller_support")
	private String controllerSupport;

	@SerializedName("about_the_game")
	private String aboutTheGame;

	@SerializedName("recommendations")
	private Recommendations recommendations;

	@SerializedName("screenshots")
	private List<ScreenshotsItem> screenshots;

	@SerializedName("platforms")
	private Platforms platforms;

	@SerializedName("movies")
	private List<MoviesItem> movies;

	@SerializedName("genres")
	private List<GenresItem> genres;

	@SerializedName("publishers")
	private List<String> publishers;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	@SerializedName("website")
	private String website;

	@SerializedName("packages")
	private List<Integer> packages;

	@SerializedName("required_age")
	private String requiredAge;

	@SerializedName("detailed_description")
	private String detailedDescription;

	@SerializedName("support_info")
	private SupportInfo supportInfo;

	@SerializedName("ext_user_account_notice")
	private String extUserAccountNotice;

	@SerializedName("package_groups")
	private List<PackageGroupsItem> packageGroups;

	@SerializedName("release_date")
	private ReleaseDate releaseDate;

	@SerializedName("background")
	private String background;

	@SerializedName("is_free")
	private boolean isFree;

	@SerializedName("name")
	private String name;

	private Twitch twitch;

	public Twitch getTwitch() {
		return twitch;
	}

	public void setTwitch(Twitch twitch) {
		this.twitch = twitch;
	}

	public void setHeaderImage(String headerImage){
		this.headerImage = headerImage;
	}

	public String getHeaderImage(){
		return headerImage;
	}

	public void setShortDescription(String shortDescription){
		this.shortDescription = shortDescription;
	}

	public String getShortDescription(){
		return shortDescription;
	}

	public void setSupportedLanguages(String supportedLanguages){
		this.supportedLanguages = supportedLanguages;
	}

	public String getSupportedLanguages(){
		return supportedLanguages;
	}

	public void setLegalNotice(String legalNotice){
		this.legalNotice = legalNotice;
	}

	public String getLegalNotice(){
		return legalNotice;
	}

	public void setAchievements(Achievements achievements){
		this.achievements = achievements;
	}

	public Achievements getAchievements(){
		return achievements;
	}

	public void setDevelopers(List<String> developers){
		this.developers = developers;
	}

	public List<String> getDevelopers(){
		return developers;
	}

	public void setMetacritic(Metacritic metacritic){
		this.metacritic = metacritic;
	}

	public Metacritic getMetacritic(){
		return metacritic;
	}

	public void setSteamAppid(int steamAppid){
		this.steamAppid = steamAppid;
	}

	public int getSteamAppid(){
		return steamAppid;
	}

	public void setPcRequirements(PcRequirements pcRequirements){
		this.pcRequirements = pcRequirements;
	}

	public PcRequirements getPcRequirements(){
		return pcRequirements;
	}

	public void setPriceOverview(PriceOverview priceOverview){
		this.priceOverview = priceOverview;
	}

	public PriceOverview getPriceOverview(){
		return priceOverview;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setControllerSupport(String controllerSupport){
		this.controllerSupport = controllerSupport;
	}

	public String getControllerSupport(){
		return controllerSupport;
	}

	public void setAboutTheGame(String aboutTheGame){
		this.aboutTheGame = aboutTheGame;
	}

	public String getAboutTheGame(){
		return aboutTheGame;
	}

	public void setRecommendations(Recommendations recommendations){
		this.recommendations = recommendations;
	}

	public Recommendations getRecommendations(){
		return recommendations;
	}

	public void setScreenshots(List<ScreenshotsItem> screenshots){
		this.screenshots = screenshots;
	}

	public List<ScreenshotsItem> getScreenshots(){
		return screenshots;
	}


	public void setPlatforms(Platforms platforms){
		this.platforms = platforms;
	}

	public Platforms getPlatforms(){
		return platforms;
	}

	public void setMovies(List<MoviesItem> movies){
		this.movies = movies;
	}

	public List<MoviesItem> getMovies(){
		return movies;
	}

	public void setGenres(List<GenresItem> genres){
		this.genres = genres;
	}

	public List<GenresItem> getGenres(){
		return genres;
	}

	public void setPublishers(List<String> publishers){
		this.publishers = publishers;
	}

	public List<String> getPublishers(){
		return publishers;
	}

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setPackages(List<Integer> packages){
		this.packages = packages;
	}

	public List<Integer> getPackages(){
		return packages;
	}

	public void setRequiredAge(String requiredAge){
		this.requiredAge = requiredAge;
	}

	public String getRequiredAge(){
		return requiredAge;
	}

	public void setDetailedDescription(String detailedDescription){
		this.detailedDescription = detailedDescription;
	}

	public String getDetailedDescription(){
		return detailedDescription;
	}

	public void setSupportInfo(SupportInfo supportInfo){
		this.supportInfo = supportInfo;
	}

	public SupportInfo getSupportInfo(){
		return supportInfo;
	}

	public void setExtUserAccountNotice(String extUserAccountNotice){
		this.extUserAccountNotice = extUserAccountNotice;
	}

	public String getExtUserAccountNotice(){
		return extUserAccountNotice;
	}

	public void setPackageGroups(List<PackageGroupsItem> packageGroups){
		this.packageGroups = packageGroups;
	}

	public List<PackageGroupsItem> getPackageGroups(){
		return packageGroups;
	}

	public void setReleaseDate(ReleaseDate releaseDate){
		this.releaseDate = releaseDate;
	}

	public ReleaseDate getReleaseDate(){
		return releaseDate;
	}

	public void setBackground(String background){
		this.background = background;
	}

	public String getBackground(){
		return background;
	}

	public void setIsFree(boolean isFree){
		this.isFree = isFree;
	}

	public boolean isIsFree(){
		return isFree;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Game{" + 
			"header_image = '" + headerImage + '\'' + 
			",short_description = '" + shortDescription + '\'' + 
			",supported_languages = '" + supportedLanguages + '\'' + 
			",legal_notice = '" + legalNotice + '\'' + 
			",achievements = '" + achievements + '\'' + 
			",developers = '" + developers + '\'' + 
			",metacritic = '" + metacritic + '\'' + 
			",steam_appid = '" + steamAppid + '\'' + 
			",pc_requirements = '" + pcRequirements + '\'' + 
			",price_overview = '" + priceOverview + '\'' + 
			",type = '" + type + '\'' + 
			",controller_support = '" + controllerSupport + '\'' + 
			",about_the_game = '" + aboutTheGame + '\'' + 
			",recommendations = '" + recommendations + '\'' + 
			",screenshots = '" + screenshots + '\'' +
			",publishers = '" + publishers + '\'' + 
			",categories = '" + categories + '\'' + 
			",website = '" + website + '\'' + 
			",packages = '" + packages + '\'' + 
			",required_age = '" + requiredAge + '\'' + 
			",detailed_description = '" + detailedDescription + '\'' + 
			",support_info = '" + supportInfo + '\'' + 
			",ext_user_account_notice = '" + extUserAccountNotice + '\'' + 
			",package_groups = '" + packageGroups + '\'' + 
			",release_date = '" + releaseDate + '\'' + 
			",background = '" + background + '\'' + 
			",is_free = '" + isFree + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}