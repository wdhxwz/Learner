package com.wangdh.learner.base.lambda;

import java.util.List;

/**
 * 音乐家
 * @author PC
 *
 */
public class Artist {
	/**
	 * 艺术家的名字
	 */
	private String name;
	
	/**
	 * 乐队成员
	 */
	private String members;
	
	/**
	 * 乐队来自哪里
	 */
	private String origin;
	
	/**
	 * 专辑
	 */
	private Album album;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
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

	/**
	 * 曲目
	 * @author PC
	 *
	 */
	public static class Track{
		/**
		 * 歌曲名称
		 */
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	/**
	 * 专辑
	 * @author PC
	 *
	 */
	public static class Album{
		/**
		 * 专辑名称
		 */
		private String name;
		
		/**
		 * 歌曲列表
		 */
		private List<Track> tracks;
		
		/**
		 * 参与创作的艺术家列表
		 */
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