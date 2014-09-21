package com.example.Value.recommentation;

/**
 * @author mukai_masaki on 2014/09/22.
 *         Copyright: CYBER AGNET. INC
 */
public class Tip {

	private String id;
	private String text;
	private String type;
	private String url;
	private String canonicalUrl;
	private Like likes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCanonicalUrl() {
		return canonicalUrl;
	}

	public void setCanonicalUrl(String canonicalUrl) {
		this.canonicalUrl = canonicalUrl;
	}

	public Like getLikes() {
		return likes;
	}

	public void setLikes(Like likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Tip{" +
				"id='" + id + '\'' +
				", text='" + text + '\'' +
				", type='" + type + '\'' +
				", url='" + url + '\'' +
				", canonicalUrl='" + canonicalUrl + '\'' +
				", likes=" + likes +
				'}';
	}
}
