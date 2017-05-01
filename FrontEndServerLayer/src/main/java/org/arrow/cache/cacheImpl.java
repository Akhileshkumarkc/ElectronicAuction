//package org.arrow.cache;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.util.concurrent.Future;
//
//import net.spy.memcached.MemcachedClient;
//
//public class cacheImpl {
//	public static void addCache(String key, String value) throws IOException{
//	    try{
//	    	 MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
//	         Future fo = mcc.set(key, 900, value);
//	         mcc.shutdown();
//	      }catch(Exception ex){
//	         System.out.println( ex.getMessage() );
//	      }
//	   }
//	public static void getCache(String key) throws IOException{
//		MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
//        mcc.get(key);
//	}
//	public static void main(String[] args) throws IOException{
//		addCache("Akhilesh","Check");
//	}
//}
