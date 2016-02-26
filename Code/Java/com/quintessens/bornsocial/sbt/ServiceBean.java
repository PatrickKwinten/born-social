package com.quintessens.bornsocial.sbt;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.ibm.sbt.services.client.connections.activitystreams.ActivityStreamEntityList;
import com.ibm.sbt.services.client.connections.activitystreams.ActivityStreamService;
import com.ibm.sbt.services.client.connections.blogs.BlogList;
import com.ibm.sbt.services.client.connections.blogs.BlogService;
import com.ibm.sbt.services.client.connections.bookmarks.BookmarkList;
import com.ibm.sbt.services.client.connections.bookmarks.BookmarkService;
import com.ibm.sbt.services.client.connections.communities.CommunityList;
import com.ibm.sbt.services.client.connections.communities.CommunityService;
import com.ibm.sbt.services.client.connections.files.FileList;
import com.ibm.sbt.services.client.connections.files.FileService;
import com.ibm.sbt.services.client.connections.files.FileServiceException;
import com.ibm.sbt.services.client.connections.forums.ForumList;
import com.ibm.sbt.services.client.connections.forums.ForumService;
import com.ibm.sbt.services.client.connections.forums.TopicList;
import com.ibm.sbt.services.client.connections.profiles.Profile;
import com.ibm.sbt.services.client.connections.profiles.ProfileList;
import com.ibm.sbt.services.client.connections.profiles.ProfileService;
import com.ibm.sbt.services.client.connections.profiles.ProfileServiceException;

public class ServiceBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public ActivityStreamEntityList getAllStatusUpdates() {
		ActivityStreamService service = new ActivityStreamService();
		try {
			return service.getAllUpdates();
		} catch (Throwable e) {
			return null;
		}
	}

	public ActivityStreamEntityList getMyStatusUpdates() {
		ActivityStreamService service = new ActivityStreamService();
		try {
			return service.getMyStatusUpdates();
		} catch (Throwable e) {
			return null;
		}
	}

	public ActivityStreamEntityList getMyNetworkStatusUpdates() {
		ActivityStreamService service = new ActivityStreamService();
		try {
			return service.getStatusUpdatesFromMyNetwork();
		} catch (Throwable e) {
			return null;
		}
	}

	public ActivityStreamEntityList getMyNetworkUpdates() {
		ActivityStreamService service = new ActivityStreamService();
		try {
			return service.getUpdatesFromMyNetwork();
		} catch (Throwable e) {
			return null;
		}
	}

	public ActivityStreamEntityList getUpdatesIFollow() {
		ActivityStreamService service = new ActivityStreamService();
		try {
			return service.getUpdatesFromPeopleIFollow();
		} catch (Throwable e) {
			return null;
		}
	}

	public FileList getMyFiles() {
		FileService service = new FileService();
		try {
			return service.getMyFiles();
		} catch (FileServiceException e) {
			return null;
		}
	}

	public ProfileList getMyColleagues() {
		ProfileService service = new ProfileService();
		try {
			Profile profile = service.getMyProfile();
			ProfileList profiles = service.getColleagues(profile.getUserid());
			return profiles;
		} catch (ProfileServiceException e) {
			return null;
		}
	}

	public Profile getMyProfile() {
		ProfileService service = new ProfileService();
		try {
			Profile profile = service.getMyProfile();
			return profile;
		} catch (ProfileServiceException e) {
			return null;
		}
	}

	public BlogList getAllBlogs() {
		BlogService service = new BlogService();
		try {
			BlogList entries = service.getAllBlogs();
			return entries;
		} catch (Throwable e) {
			return null;
		}
	}

	public BlogList getMyBlogs() {
		BlogService service = new BlogService();
		try {
			BlogList entries = service.getMyBlogs();
			return entries;
		} catch (Throwable e) {
			return null;
		}
	}

	public BookmarkList getAllBookmarks() {
		BookmarkService svc = new BookmarkService();
		try {
			BookmarkList bookmarks = svc.getAllBookmarks();
			return bookmarks;
		} catch (Throwable e) {
			return null;
		}
	}

	public BookmarkList getPopularBookmarks() {
		BookmarkService svc = new BookmarkService();
		try {
			BookmarkList bookmarks = svc.getPopularBookmarks();
			return bookmarks;
		} catch (Throwable e) {
			return null;
		}
	}

	public BookmarkList getMyBookmarks() {
		BookmarkService svc = new BookmarkService();
		try {
			BookmarkList bookmarks = svc.getMyNotifications();
			return bookmarks;
		} catch (Throwable e) {
			return null;
		}
	}

	public CommunityList getAllCommunities() {
		CommunityService svc = new CommunityService();
		try {
			CommunityList comms = svc.getPublicCommunities();
			return comms;
		} catch (Throwable e) {
			return null;
		}
	}

	public CommunityList getMyCommunitiesFilter() {
		// incomplete, not possible to send in a filter yet...
		CommunityService svc = new CommunityService();
		Map<String, String> map = new HashMap<String, String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put("tag", "sverige");

			}
		};
		try {
			CommunityList comms = svc.getMyCommunities(map);
			return comms;
		} catch (Throwable e) {
			return null;
		}
	}

	public CommunityList getMyCommunities() {
		CommunityService svc = new CommunityService();
		try {
			CommunityList comms = svc.getMyCommunities();
			return comms;
		} catch (Throwable e) {
			return null;
		}
	}

	public ForumList getMyForums() {
		ForumService svc = new ForumService();
		try {
			ForumList forums = svc.getMyForums();
			return forums;
		} catch (Throwable e) {
			return null;
		}
	}

	public TopicList getMyForumsTopics() {
		ForumService svc = new ForumService();
		try {
			TopicList forums = svc.getMyForumTopics();
			return forums;
		} catch (Throwable e) {
			return null;
		}
	}

}
