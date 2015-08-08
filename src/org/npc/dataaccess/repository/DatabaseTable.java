package org.npc.dataaccess.repository;

public enum DatabaseTable {
	NONE(""),
	ACCOUNT_INDEX_LOOKUP("accountlookup"),
	ACCOUNT_INDEX_REPOSITORY("accountrepository"),
	ACCOUNT_INDEX_ALIAS("accountalias"),
	ACCOUNT("account"),
	ACCOUNT_NOTIFICATION("accountnotification"),
	INTERNAL_ACCOUNT_DETAILS("internalaccountdetails"),
	FACEBOOK_ACCOUNT_DETAILS("facebookaccountdetails"),
	TWITTER_ACCOUNT_DETAILS("twitteraccountdetails"),
	FOLLOWING_ACCOUNT("followingaccount"),
	CHALLENGE_INDEX_LOOKUP("challengelookup"),
	CHALLENGE_INDEX_REPOSITORY("challengerepository"),
	CHALLENGE_INDEX_TRACKED_SHARE_LOOKUP("trackedchallengesharelookup"),
	CHALLENGE("challenge"),
	CHALLENGE_APPLIED_CATEGORY("challengeappliedcategory"),
	CHALLENGE_TAG("challengetag"),
	CHALLENGE_TRACKED_SHARE("trackedchallengeshare"),
	VIDEO_INDEX_LOOKUP("videolookup"),
	VIDEO_INDEX_REPOSITORY("videorepository"),
	VIDEO_INDEX_EVENT("videoevent"),
	VIDEO_INDEX_EVENT_PARAMETER("videoeventparameter"),
	VIDEO_POPULARITY("videopopularity"),
	VIDEO_POPULARITY_PARTITION_KEY("videopopularitypartitionkey"),
	VIDEO("video"),
	VIDEO_COMMENT("videocomment"),
	BEST_VIDEO_VOTE("bestvideovote"),
	SERVICE("serviceindex"),
	SERVICE_SUBSCRIPTION("subscribers");
	
	public String getLabel() {
		return label;
	}
	
	private final String label;
	
	private DatabaseTable(String label) {
		this.label = label;
	}
}
