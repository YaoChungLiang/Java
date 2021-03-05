package com.antra;

public class Criteria {
	private String folderPath;
	private String includeSubFolder;
	private String extension;
	
	Criteria(String folderPath, String includeSubFolder, String extension){
		this.folderPath = folderPath;
		this.includeSubFolder = includeSubFolder;
		this.extension = extension;
	}
	
	public String getFolderPath() {
		return folderPath;
	}
	
	public String getIncludeSubFolder() {
		return includeSubFolder;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	
	public void setIncludeSubFolder(String includeSub) {
		this.includeSubFolder = includeSub;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
}
