package org.arrow.cache;

import org.arrow.model.SimpleUserModel;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class cacheImpl	 {
	private static MemCachedClient cacheObj = null;
	static {
		String[] server = { "localhost:11211" };
		SockIOPool sockPool = SockIOPool.getInstance("auctionBids");
		sockPool.setServers(server);
		sockPool.setFailover(true);
		sockPool.setInitConn(11);
		sockPool.setMinConn(4);
		sockPool.setMaxConn(280);
		sockPool.setMaintSleep(25);
		sockPool.setNagle(false);
		sockPool.setSocketTO(3100);
		sockPool.setAliveCheck(true);
		sockPool.initialize();
		cacheObj = new MemCachedClient("auctionBids");
	}

	public static boolean addToCache(String key, String value) {
		System.out.println("Added to cache!");
		return cacheObj.set(key, value);
	}

	public static String getFromCache(String key) {
		Object cacheKey = cacheObj.get(key);
		if (cacheKey == null) {
			System.out.println("It's a cache miss! Username not present in cache");
			return null;
			
		} else {
			System.out.println("It's a cache hit! Username present in cache");
			return (String) cacheKey;
		}
	}

}
