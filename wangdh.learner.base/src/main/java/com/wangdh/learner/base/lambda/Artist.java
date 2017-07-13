package com.wangdh.learner.base.lambda;

import java.util.List;

public class Artist {
	private String name;
	private String menbers;
	private String origin;
	private Album album;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenbers() {
		return menbers;
	}

	public void setMenbers(String menbers) {
		this.menbers = menbers;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public static class Track{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public static class Album{
		private String name;
		private List<Track> tracks;
		private String musicians;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Track> getTracks() {
			return tracks;
		}
		public void setTracks(List<Track> tracks) {
			this.tracks = tracks;
		}
		public String getMusicians() {
			return musicians;
		}
		public void setMusicians(String musicians) {
			this.musicians = musicians;
		}
	}
}


